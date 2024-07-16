package com.example.BookMyShow.services;

import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    private ShowSeatTypeRepository showSeatTypeRepository;

    @Autowired
    public BookingService(
            UserRepository userRepository,
            ShowRepository showRepository,
            ShowSeatRepository showSeatRepository,
            BookingRepository bookingRepository,
            ShowSeatTypeRepository showSeatTypeRepository
    ) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(
            List<Integer> showSeatIds,
            int showId,
            int userId
    ) {
        // 1. Get the User from userId
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOptional.get();

        // 2. Get the Show from showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()) {
            throw new RuntimeException("Show not found");
        }
        Show show = showOptional.get();

        //        Transaction start
        // 3. Get the ShowSeat from Ids
        // 4. Check if all the seats are available
        // 5. if no, throw error return the response

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.EMPTY)) {
                throw new RuntimeException("Show seat not empty");
            }
        }

        // 6. if yes, make the seats as blocked
        List<ShowSeat> showSeatList = new ArrayList<>();
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            // 7. save the updates data of showseats in the db
            showSeatList.add( showSeatRepository.save(showSeat) );
        }

        //        Transaction end
        // 8. create a corresponding booking object
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShow(show);
        booking.setShowSeats(showSeatList);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookedAt(new Date());
        double amount = showSeatTypeRepository.findAllByShow(show).stream()
                .map(ShowSeatType::getPrice)
                .reduce(0.0, Double::sum);

        booking.setAmount(amount);
        booking.setPayments(new ArrayList<>());


        bookingRepository.save(booking);
        // 9. return the booking object
        return booking;
    }
}

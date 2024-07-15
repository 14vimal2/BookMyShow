package com.example.BookMyShow.controllers;

import com.example.BookMyShow.services.BookingService;
import com.example.BookMyShow.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO bookTicketRequestDTO) {
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
//        return responseDTO;
        try {
            Booking booking = bookingService.bookTicket(
                    bookTicketRequestDTO.getShowSeatIds(),
                    bookTicketRequestDTO.getShowId(),
                    bookTicketRequestDTO.getUserId()
            );
            responseDTO.setBookingId(booking.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setAmount(booking.getAmount());

        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}

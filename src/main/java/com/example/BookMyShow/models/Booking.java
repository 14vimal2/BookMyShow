package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;
    private BookingStatus bookingStatus;
    private Date bookedAt;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    private int amount;
    @OneToMany
    private List<Payment> payments;
}

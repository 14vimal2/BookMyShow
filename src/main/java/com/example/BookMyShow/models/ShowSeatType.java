package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    private Show show;
    private SeatType seatType;
    private double price;

}

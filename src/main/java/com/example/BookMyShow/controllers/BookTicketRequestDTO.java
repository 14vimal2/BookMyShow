package com.example.BookMyShow.controllers;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeatIds;
    private int showId;
    private int userId;

}
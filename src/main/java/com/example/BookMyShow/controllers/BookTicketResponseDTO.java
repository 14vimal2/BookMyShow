package com.example.BookMyShow.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private ResponseStatus responseStatus;
    private int bookingId;
    private int amount;
}

package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    private int refNo;
    private PaymentMode paymentMode;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}

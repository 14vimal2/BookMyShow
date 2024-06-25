package com.example.BookMyShow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private Movie movie;
    private Date startTime;
    private Screen screen;
    private int duration;
    private List<Feature> features;

}

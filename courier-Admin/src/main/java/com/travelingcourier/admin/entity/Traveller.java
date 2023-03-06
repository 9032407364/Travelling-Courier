package com.travelingcourier.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Traveller {

    private int travelerID;
    private String name;
    private String email;
    private String phone;
    // private String panCard;
    //private String adharCard;
    private String address;
    private String departureSource;
    private String arrivalDestination;
    private String departureTime;
    private String arrivalTime;

}

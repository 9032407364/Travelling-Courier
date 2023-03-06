package com.travelingcourier.dto;

import lombok.Data;

@Data
public class Traveller {

    private int travelerID;
    private String name;
    private String email;
    private String phone;
    private String panCard;
    private String adharCard;
    private String address;
    private String departureSource;
    private String arrivalDestination;
    private String departureTime;
    private String arrivalTime;
}

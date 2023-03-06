package com.travelingcourier.admin.model1;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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

package com.travelingcourier.traveler.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "traveller")
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

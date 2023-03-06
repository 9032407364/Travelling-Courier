package com.courier.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travelerID;
    private String name;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String panCard;
    private String adharCard;
    private boolean isActive;
    private String departureSource;
    private String arrivalDestination;
    private String departureTime;
    private String arrivalTime;

    //getters and setters
    @Enumerated(EnumType.STRING)
    private Role role;
}


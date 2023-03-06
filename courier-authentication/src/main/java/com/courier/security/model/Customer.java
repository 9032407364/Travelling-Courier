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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String firstname;
    private String lastname;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String panCard;
    private String adharCard;
    private String couriersource;
    private String courierdestination;

    private boolean isActive;
    //getters and setters
    @Enumerated(EnumType.STRING)
    private Role role;
}

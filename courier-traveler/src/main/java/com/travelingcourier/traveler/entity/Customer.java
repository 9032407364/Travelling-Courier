package com.travelingcourier.traveler.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private int customerId;
    private String name;
    private String email;

    private String phone;
    private String panCard;
    private String adharCard;
    private String address;
    private String couriersource;
    private String courierdestination;

}

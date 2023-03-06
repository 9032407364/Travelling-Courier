package com.travelingcourier.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {


    private int customerId;
    private String name;
    private String email;

    private String phone;
    //private String panCard;
    //private String adharCard;
    private String address;
    private String couriersource;
    private String courierdestination;

}

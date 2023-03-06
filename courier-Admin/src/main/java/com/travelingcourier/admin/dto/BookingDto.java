package com.travelingcourier.admin.dto;


import com.travelingcourier.admin.entity.Traveller;
import com.travelingcourier.admin.model1.Courier;
import com.travelingcourier.admin.model1.Customer;

import jakarta.persistence.*;
import lombok.Data;

@Data


public class BookingDto {

    private int bookingId;

    private Customer customer;

    Traveller traveller;

    Courier courier;



}

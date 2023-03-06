package com.travelingcourier.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="booking_details")
@Entity

public class BookingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "traveler_id")
    Traveller traveller;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id")
    Courier courier;



}

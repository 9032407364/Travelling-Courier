package com.travelingcourier.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="adminVerification")
public class AdminVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int verificationId;
    private int bookingId;
    private int paymentId;



}

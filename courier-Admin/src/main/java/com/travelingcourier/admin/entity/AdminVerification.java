package com.travelingcourier.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "adminVerification")
public class AdminVerification {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int verificationId;
    private int bookingId;
    private int paymentId;

    private String verificationstatus;


}

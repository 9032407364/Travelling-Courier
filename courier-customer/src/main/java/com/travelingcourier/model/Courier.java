package com.travelingcourier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courier")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;


//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

   
    private String description;

    
    private double weight;

    
    private String size;

    
    private int quantity;

    @Future(message = "Sending date must be in the future")
    private Date sendingDate;
    @NotBlank(message = "from Location is required")
    private String sendingFrom;
    @NotBlank(message = "to Location is required")
    private String sendingTo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;




}


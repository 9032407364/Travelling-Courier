package com.travelingcourier.admin.model1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Courier {
@Id
    private Long packageId;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

   
    private String description;

    
    private double weight;

    
    private String size;

    
    private int quantity;
    

}


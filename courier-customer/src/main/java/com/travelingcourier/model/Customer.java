package com.travelingcourier.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String adharCard;
	@OneToMany(mappedBy = "customer")
	private List<Courier> courier;


}

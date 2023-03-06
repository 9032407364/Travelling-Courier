package com.travelingcourier.admin.model1;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {
@Id
	private int customerId;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String aadhar;

	private String departureSource;
	private String arrivalDestination;
	private String departureTime;
	private String arrivalTime;
}

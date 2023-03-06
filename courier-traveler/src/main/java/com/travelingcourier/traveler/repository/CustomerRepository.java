package com.travelingcourier.traveler.repository;

import com.travelingcourier.traveler.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}

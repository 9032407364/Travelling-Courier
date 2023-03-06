package com.travelingcourier.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelingcourier.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}


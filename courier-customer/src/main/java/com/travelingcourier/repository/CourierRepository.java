package com.travelingcourier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelingcourier.model.Courier;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer>{
	
}

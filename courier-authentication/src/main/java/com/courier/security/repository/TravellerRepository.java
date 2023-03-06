package com.courier.security.repository;

import com.courier.security.model.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravellerRepository extends JpaRepository<Traveller, Integer> {
    Optional<Traveller> findByEmail(String email);
}
package com.travelingcourier.repository;

import com.travelingcourier.model.AdminVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminVerificationRepository extends JpaRepository<AdminVerification, Integer> {

}

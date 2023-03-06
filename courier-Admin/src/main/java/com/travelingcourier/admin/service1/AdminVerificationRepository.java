package com.travelingcourier.admin.service1;

import com.travelingcourier.admin.entity.AdminVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminVerificationRepository extends JpaRepository<AdminVerification, Integer> {

}

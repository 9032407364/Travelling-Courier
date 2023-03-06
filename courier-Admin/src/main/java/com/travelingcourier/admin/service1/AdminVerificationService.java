package com.travelingcourier.admin.service1;

import com.travelingcourier.admin.entity.AdminVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminVerificationService {

    private final AdminVerificationRepository adminVerificationRepository;

    @Autowired
    public AdminVerificationService(AdminVerificationRepository adminVerificationRepository) {
        this.adminVerificationRepository = adminVerificationRepository;
    }

    public List<AdminVerification> findAll() {
        return adminVerificationRepository.findAll();
    }

    public AdminVerification save(AdminVerification adminVerification) {
        return adminVerificationRepository.save(adminVerification);
    }

    public Optional<AdminVerification> findById(int id) {
        return adminVerificationRepository.findById(id);
    }

    // other methods for performing CRUD operations on the AdminVerification entity
}

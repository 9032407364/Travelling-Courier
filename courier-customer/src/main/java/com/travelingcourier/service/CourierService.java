package com.travelingcourier.service;

import java.util.List;

import com.travelingcourier.feign.TravellerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelingcourier.model.Courier;
import com.travelingcourier.repository.CourierRepository;

@Service
public class CourierService {
    @Autowired
    private CourierRepository courierRepo;
    @Autowired
    private TravellerClient travellerClient;

    public Courier createCourier(Courier courier) {

        return courierRepo.save(courier);
    }

    public List<Courier> listCourier() {

        return courierRepo.findAll();
    }

    public Courier showCourierById(int packageId) {
        // TODO Auto-generated method stub
        return courierRepo.findById(packageId).orElse(null);
    }

    public String deleteCourier(int packageId) {
        courierRepo.deleteById(packageId);
        return "courier deleted";

    }

}

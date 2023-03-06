package com.travelingcourier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelingcourier.model.Courier;
import com.travelingcourier.service.CourierService;

@RestController
@RequestMapping("/api/v2/courier")
public class CourierController {
    @Autowired
    private CourierService courierService;

    @PostMapping("/save")
    public Courier createCourier(@RequestBody Courier courier) {
        return courierService.createCourier(courier);

    }

    @GetMapping("/show/courierDetails")
    public List<Courier> ListCourier() {
        return courierService.listCourier();
    }

    @GetMapping("/show/courierDetails/{packageId}")
    public Courier showCourierById(@PathVariable int packageId) {
        return courierService.showCourierById(packageId);
    }

    @DeleteMapping("/delete/courier/{packageId}")
    public String deleteCourier(@PathVariable int packageId) {
        return courierService.deleteCourier(packageId);
    }

}

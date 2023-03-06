package com.travelingcourier.admin.controller1;


import com.travelingcourier.admin.model1.Courier;
import com.travelingcourier.admin.service1.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class CourierController {
    @Autowired
    private CourierService courierService;

    @PostMapping("/api/courier/create")
    public ResponseEntity<Courier> createCourier(@RequestBody Courier courier, @RequestHeader("Authorization") String bearerToken) {
        Courier createdCourier = courierService.createCourier(courier, bearerToken);
        return new ResponseEntity<>(createdCourier, HttpStatus.CREATED);
    }

    @GetMapping("/api/courier/list")
    public ResponseEntity<List<Courier>> listCourier(@RequestHeader("Authorization") String bearerToken) {
        List<Courier> couriers = courierService.listCourier(bearerToken);
        return new ResponseEntity<>(couriers, HttpStatus.OK);
    }

    @GetMapping("/api/courier/{id}")
    public ResponseEntity<Courier> showCourierById(@PathVariable int id, @RequestHeader("Authorization") String bearerToken) {
        Courier courier = courierService.showCourierById(id, bearerToken);
        return new ResponseEntity<>(courier, HttpStatus.OK);
    }

    @DeleteMapping("/api/courier/{id}")
    public ResponseEntity<String> deleteCourier(@PathVariable int id, @RequestHeader("Authorization") String bearerToken) {
        String message = courierService.deleteCourier(id, bearerToken);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}


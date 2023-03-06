package com.travelingcourier.admin.controller1;


import com.travelingcourier.admin.entity.Customer;
import com.travelingcourier.admin.entity.Traveller;
import com.travelingcourier.admin.service1.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
public class TravellerController {
    @Autowired
    private TravellerService travellerService;

    @PostMapping("/save")
    public ResponseEntity<Traveller> saveNew(@RequestBody Traveller traveller, @RequestHeader("Authorization") String token) {
        Traveller newTraveller = travellerService.save(traveller, token);
        return new ResponseEntity<>(newTraveller, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Traveller>> getAllTraveller(@RequestHeader("Authorization") String token) {
        List<Traveller> travellers = travellerService.getAll(token);
        return new ResponseEntity<>(travellers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Traveller>> getById(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        Optional<Traveller> traveller = travellerService.getById(id, token);
        return new ResponseEntity<>(traveller, HttpStatus.OK);
    }

    @PostMapping("/save/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String token) {
        Customer newCustomer = travellerService.saveCustomer(customer, token);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/search/{departureSource}/{arrivalDestination}/{departureTime}")
    public ResponseEntity<List<Traveller>> searchForTravellers(@PathVariable String departureSource,
                                                               @PathVariable String arrivalDestination,
                                                               @PathVariable String departureTime, @RequestHeader("Authorization") String token) {
        List<Traveller> travellers = travellerService.serchForTraveller(departureSource, arrivalDestination, departureTime, token);
        return new ResponseEntity<>(travellers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTraveller(@PathVariable int id, @RequestHeader("Authorization") String token) {
        travellerService.deleteTraveller(id, token);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Traveller> updateTraveller(@RequestBody Traveller traveller, @RequestHeader("Authorization") String token) {
        Traveller updatedTraveller = travellerService.updateTraveller(traveller, token);
        return new ResponseEntity<>(updatedTraveller, HttpStatus.OK);
    }

}
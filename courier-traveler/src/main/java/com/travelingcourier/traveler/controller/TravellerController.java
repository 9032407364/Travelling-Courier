package com.travelingcourier.traveler.controller;

import com.travelingcourier.traveler.entity.Customer;
import com.travelingcourier.traveler.entity.Traveller;
import com.travelingcourier.traveler.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4/travel")
public class TravellerController {
    @Autowired
    private TravellerService travellerService;

    @PostMapping("/save")
    public Traveller saveNew(@RequestBody Traveller traveller) {
        return travellerService.save(traveller);
    }

    @GetMapping("/")
    public List<Traveller> getAllTraveller() {
        return travellerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Traveller> getById(@PathVariable int id) {
        return travellerService.getById(id);
    }

    @PostMapping("/save/customer")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return travellerService.saveCustomer(customer);
    }

    @GetMapping("/search/{departureSource}/{arrivalDestination}/{departureTime}")
    public List<Traveller> searchForTravellers(@PathVariable String departureSource,
                                               @PathVariable String arrivalDestination,
                                               @PathVariable String departureTime) {
        return travellerService.serchForTraveller(departureSource, arrivalDestination, departureTime);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTraveller(@PathVariable int id) {
        travellerService.deleteTraveller(id);
    }

    @PutMapping("/update")
    public Traveller updateTraveller(@RequestBody Traveller traveller) {
        return travellerService.updateTraveller(traveller);
    }


}

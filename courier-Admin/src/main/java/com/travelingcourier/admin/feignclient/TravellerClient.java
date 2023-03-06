package com.travelingcourier.admin.feignclient;


import com.travelingcourier.admin.entity.Customer;
import com.travelingcourier.admin.entity.Traveller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "TRAVELLER-SERVICE")
public interface TravellerClient {

    @PostMapping("/api/v4/travel/save")
    Traveller save(@RequestBody Traveller traveller, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v4/travel/")
    List<Traveller> getAll(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v4/travel/{id}")
    Optional<Traveller> getById(@PathVariable Long id, @RequestHeader("Authorization") String bearerToken);

    @PostMapping("/api/v4/travel/save/customer")
    Customer saveCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v4/travel/search/{departureSource}/{arrivalDestination}/{departureTime}")
    List<Traveller> searchForTravellers(@PathVariable String departureSource,
                                        @PathVariable String arrivalDestination,
                                        @PathVariable String departureTime, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping("/api/v4/travel/delete/{id}")
    void deleteTraveller(@PathVariable int id, @RequestHeader("Authorization") String authorization);


    @PutMapping("/api/v4/travel/update")
    Traveller updateTraveller(@RequestBody Traveller traveller, @RequestHeader("Authorization") String bearerToken);

}

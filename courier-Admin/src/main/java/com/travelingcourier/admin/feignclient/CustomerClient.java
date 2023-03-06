package com.travelingcourier.admin.feignclient;


import com.travelingcourier.admin.model1.Customer;
import com.travelingcourier.admin.model1.Traveller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {

    @PostMapping("/api/v2/customer/register")
    Customer addCustomer(@RequestBody Customer user, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v2/customer/show/users")
    List<Customer> getAllUsers(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v2/customer/show/users/{customerId}")
    Customer getCustomersById(@PathVariable int customerId, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping("/api/v2/customer/delete/users/{customerId}")
    String deleteCustomer(@PathVariable int customerId, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v2/customer/{id}")
    Optional<Traveller> getTraveller(@RequestHeader("Authorization") String bearerToken, @PathVariable int id);

    @PutMapping("/api/v2/customer")
    Customer updateCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String bearerToken);
}


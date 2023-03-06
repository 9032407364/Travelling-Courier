package com.travelingcourier.admin.controller1;


import com.travelingcourier.admin.model1.Customer;
import com.travelingcourier.admin.model1.Traveller;
import com.travelingcourier.admin.service1.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer/register")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer user, @RequestHeader("Authorization") String bearerToken) {
        Customer customer = customerService.addCustomer(user, bearerToken);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/customer/show/users")
    public ResponseEntity<List<Customer>> getAllUsers(@RequestHeader("Authorization") String bearerToken) {
        List<Customer> customers = customerService.getAllUsers(bearerToken);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customer/show/users/{customerId}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable int customerId, @RequestHeader("Authorization") String bearerToken) {
        Customer customer = customerService.getCustomersById(customerId, bearerToken);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customer/delete/users/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId, @RequestHeader("Authorization") String bearerToken) {
        String message = customerService.deleteCustomer(customerId, bearerToken);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Optional<Traveller>> getTraveller(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        Optional<Traveller> traveller = customerService.getTraveller(bearerToken, id);
        return new ResponseEntity<>(traveller, HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String bearerToken) {
        Customer updatedCustomer = customerService.updateCustomer(customer, bearerToken);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
}

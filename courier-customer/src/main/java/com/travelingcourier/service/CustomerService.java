package com.travelingcourier.service;

import java.util.List;
import java.util.Optional;

import com.travelingcourier.dto.Traveller;
import com.travelingcourier.feign.AuthClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelingcourier.model.Customer;
import com.travelingcourier.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository customerRepo;
    @Autowired
    public AuthClient authClient;


    public Customer createCustomer(Customer customer) {

        return customerRepo.save(customer);
    }


    public List<Customer> getcustomers() {

        return customerRepo.findAll();
    }

    public Optional<Traveller> getTraveller(@RequestHeader("Authorization") String bearerToken, int id) {
        Optional<Traveller> traveller = authClient.getById(bearerToken, id);
        return traveller;
    }


    public Customer getCustomersById(int customerId) {

        return customerRepo.findById(customerId).orElse(null);
    }


    public String deletCustomer(int customerId) {

        customerRepo.deleteById(customerId);
        return "user deleted";
    }


    public Customer updateCustomer(Customer customer) {
        Customer user = customerRepo.findById(customer.getCustomerId()).get();
        if (user.equals(null)) {
            System.out.println("Customer doesn't exist");
        } else {
            user.setName(customer.getName());
            user.setEmail(customer.getEmail());
            user.setAdharCard(customer.getAdharCard());
            user.setPhone(customer.getPhone());
            user.setAddress(customer.getAddress());
        }
        return customerRepo.save(customer);
    }


}

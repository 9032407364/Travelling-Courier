package com.travelingcourier.admin.service1;


import com.travelingcourier.admin.feignclient.CustomerClient;
import com.travelingcourier.admin.model1.Customer;
import com.travelingcourier.admin.model1.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerClient customerClient;


    public Customer addCustomer(Customer user, String bearerToken) {
        return customerClient.addCustomer(user,bearerToken);
    }

    public List<Customer> getAllUsers(String bearerToken) {
        return customerClient.getAllUsers(bearerToken);
    }

    public Customer getCustomersById(int customerId, String bearerToken) {
        return customerClient.getCustomersById(customerId,bearerToken);
    }

    public String deleteCustomer(int customerId, String bearerToken) {
        return customerClient.deleteCustomer(customerId,bearerToken);
    }

    public Optional<Traveller> getTraveller(String bearerToken, int id) {
        return customerClient.getTraveller(bearerToken, id);
    }

    public Customer updateCustomer(Customer customer, String bearerToken) {
        return customerClient.updateCustomer(customer,bearerToken);
    }
}


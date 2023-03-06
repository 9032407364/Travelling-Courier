package com.travelingcourier.admin.service1;


import com.travelingcourier.admin.entity.Customer;
import com.travelingcourier.admin.entity.Traveller;
import com.travelingcourier.admin.feignclient.TravellerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravellerService {
@Autowired
private TravellerClient travellerClient;



public Traveller save(Traveller traveller, String token){
        return travellerClient.save(traveller,token);
        }

public List<Traveller> getAll(String token){
        return travellerClient.getAll( token);
        }

public Optional<Traveller> getById(Long id,String token){
        return travellerClient.getById(id, token);
        }

public Customer saveCustomer(Customer customer,String token){
        return travellerClient.saveCustomer(customer, token);
        }

public List<Traveller> serchForTraveller(String departureSource, String arrivalDestination, String departureTime,String token){
        return travellerClient.searchForTravellers(departureSource, arrivalDestination, departureTime, token);
        }

public void deleteTraveller(int id,String token){
        travellerClient.deleteTraveller(id, token);
        }

public Traveller updateTraveller(Traveller traveller,String token){
        return travellerClient.updateTraveller(traveller, token);
        }

}

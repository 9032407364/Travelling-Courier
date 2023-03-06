package com.travelingcourier.traveler.service;

import com.travelingcourier.traveler.dto.AllTravelDto;
import com.travelingcourier.traveler.entity.Customer;
import com.travelingcourier.traveler.entity.Traveller;
import com.travelingcourier.traveler.repository.CustomerRepository;
import com.travelingcourier.traveler.repository.TravellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravellerService {

    @Autowired
    private TravellerRepository travellerRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Traveller save(Traveller traveller) {
        return travellerRepository.save(traveller);
    }

    public List<Traveller> getAll() {
        return travellerRepository.findAll();
    }

    public Optional<Traveller> getById(int id) {
        return travellerRepository.findById(id);
    }

    public void deleteTraveller(int id) {
        travellerRepository.deleteById(id);
    }

    public Traveller updateTraveller(Traveller traveller) {
        Traveller updatedTraveller = new Traveller();
        Traveller exsistingTraveller = travellerRepository.findById(traveller.getTravelerID()).get();

        if (exsistingTraveller.getName() != null) {
            exsistingTraveller.setName(traveller.getName());
            exsistingTraveller.setAddress(traveller.getAddress());
            exsistingTraveller.setEmail(traveller.getEmail());
            exsistingTraveller.setPhone(traveller.getPhone());
            exsistingTraveller.setAdharCard(traveller.getAdharCard());
            exsistingTraveller.setPanCard(traveller.getPanCard());
            exsistingTraveller.setDepartureSource(traveller.getDepartureSource());
            exsistingTraveller.setArrivalDestination(traveller.getArrivalDestination());
            exsistingTraveller.setDepartureTime(traveller.getDepartureTime());
            exsistingTraveller.setArrivalTime(traveller.getArrivalTime());
            updatedTraveller = travellerRepository.save(exsistingTraveller);
        }

        return updatedTraveller;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Traveller> serchForTraveller(String departureSource, String arrivalDestination, String departureTime) {
        return travellerRepository.findListOfTraveller(departureSource, arrivalDestination, departureTime);
    }


}

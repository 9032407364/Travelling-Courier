package com.courier.security.service;

import com.courier.security.authservice.RegisterRequest;
import com.courier.security.exception.UserNotFoundException;
import com.courier.security.model.*;
import com.courier.security.repository.AdminRepository;
import com.courier.security.repository.CustomerRepository;
import com.courier.security.repository.TravellerRepository;
import com.courier.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
//@RequiredArgsConstructor
public class UserService {

    @Autowired
    TravellerRepository travellerRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User updateDetails(RegisterRequest registerRequest) throws UserNotFoundException {
        Optional<User> users = userRepository.findByEmail(registerRequest.getEmail());

        System.out.println("verify 2");
        User user = users.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
        Set<Role> roles = user.getRole();


        System.out.println("verify 3");
        for (Role role : roles) {
            if (role.equals(Role.ROLE_TRAVELLER)) {
                System.out.println("verify 4" + "" + registerRequest.getIsActive());
                user.setActive(registerRequest.getIsActive());
                Optional<Traveller> traveller = travellerRepository.findByEmail(registerRequest.getEmail());
                Traveller traveller1 = traveller.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
                traveller1.setActive(registerRequest.getIsActive());
                travellerRepository.save(traveller1);
            } else if (role.equals(Role.ROLE_CUSTOMER)) {
                user.setActive(registerRequest.getIsActive());

                Optional<Customer> Customer = customerRepository.findByEmail(registerRequest.getEmail());
                Customer Customer1 = Customer.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
                Customer1.setActive(registerRequest.getIsActive());
                customerRepository.save(Customer1);
            }
        }


        return userRepository.save(user);
    }


    public User Detailsupdate(RegisterRequest registerRequest) throws UserNotFoundException {
        Optional<User> users = userRepository.findByEmail(registerRequest.getEmail());

        System.out.println("verify 2");
        User user = users.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
        Set<Role> roles = user.getRole();


        System.out.println("verify 3");
        for (Role role : roles) {
            if (role.equals(Role.ROLE_TRAVELLER)) {
                System.out.println("verify 4" + "" + registerRequest.getIsActive());
                // user.setActive(registerRequest.getIsActive());
                user.setFirstname(registerRequest.getFirstname());
                user.setLastname(registerRequest.getLastname());
                user.setAddress(registerRequest.getAddress());
                user.setEmail(registerRequest.getEmail());
                user.setPanCard(registerRequest.getPanCard());
                user.setAdharCard(registerRequest.getAdharCard());
                user.setPhone(registerRequest.getPhone());
                user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                Optional<Traveller> traveller = travellerRepository.findByEmail(registerRequest.getEmail());
                Traveller traveller1 = traveller.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
                // traveller1.setActive(registerRequest.getIsActive());
                traveller1.setFirstname(registerRequest.getFirstname());
                traveller1.setLastname(registerRequest.getLastname());
                traveller1.setAddress(registerRequest.getAddress());
                traveller1.setEmail(registerRequest.getEmail());
                traveller1.setPhone(registerRequest.getPhone());
                traveller1.setAdharCard(registerRequest.getAdharCard());
                traveller1.setPanCard(registerRequest.getPanCard());
                traveller1.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                traveller1.setArrivalDestination(registerRequest.getArrivalDestination());
                traveller1.setDepartureSource(registerRequest.getDepartureSource());
                traveller1.setArrivalTime(registerRequest.getArrivalTime());
                traveller1.setDepartureTime(registerRequest.getDepartureTime());
                traveller1.setName(registerRequest.getName());


                travellerRepository.save(traveller1);
            } else if (role.equals(Role.ROLE_CUSTOMER)) {
                //user.setActive(registerRequest.getIsActive());
                user.setFirstname(registerRequest.getFirstname());
                user.setLastname(registerRequest.getLastname());
                user.setAddress(registerRequest.getAddress());
                user.setEmail(registerRequest.getEmail());
                user.setAdharCard(registerRequest.getAdharCard());
                user.setPanCard(registerRequest.getPanCard());
                user.setPhone(registerRequest.getPhone());
                user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

                Optional<Customer> Customer = customerRepository.findByEmail(registerRequest.getEmail());
                Customer Customer1 = Customer.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
                //Customer1.setActive(registerRequest.getIsActive());
                Customer1.setFirstname(registerRequest.getFirstname());
                Customer1.setLastname(registerRequest.getLastname());
                Customer1.setAddress(registerRequest.getAddress());
                Customer1.setEmail(registerRequest.getEmail());
                Customer1.setAdharCard(registerRequest.getAdharCard());
                Customer1.setPanCard(registerRequest.getPanCard());
                Customer1.setPhone(registerRequest.getPhone());
                Customer1.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                Customer1.setCourierdestination(registerRequest.getCourierdestination());
                Customer1.setCouriersource(registerRequest.getCouriersource());
                Customer1.setName(registerRequest.getName());
                customerRepository.save(Customer1);
            } else if (role.equals(Role.ROLE_ADMIN)) {
                //user.setActive(registerRequest.getIsActive());
                user.setFirstname(registerRequest.getFirstname());
                user.setLastname(registerRequest.getLastname());
                user.setAddress(registerRequest.getAddress());
                user.setEmail(registerRequest.getEmail());
                user.setAdharCard(registerRequest.getAdharCard());
                user.setPanCard(registerRequest.getPanCard());
                user.setPhone(registerRequest.getPhone());
                user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

                Optional<Admin> admin = adminRepository.findByEmail(registerRequest.getEmail());
                Admin admin1 = admin.orElseThrow(() -> new UserNotFoundException("User not found with email: " + registerRequest.getEmail()));
                //Customer1.setActive(registerRequest.getIsActive());
                admin1.setFirstname(registerRequest.getFirstname());
                admin1.setLastname(registerRequest.getLastname());
                admin1.setAddress(registerRequest.getAddress());
                admin1.setEmail(registerRequest.getEmail());
                admin1.setAdharCard(registerRequest.getAdharCard());
                admin1.setPanCard(registerRequest.getPanCard());

                admin1.setPhone(registerRequest.getPhone());
                admin1.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                adminRepository.save(admin1);
            }
        }


        return userRepository.save(user);
    }


}

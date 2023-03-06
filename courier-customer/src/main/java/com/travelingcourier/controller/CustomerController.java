package com.travelingcourier.controller;

import java.util.List;
import java.util.Optional;


import com.travelingcourier.feign.TravellerClient;
import com.travelingcourier.model.BookingDto;
import com.travelingcourier.model.Traveller;
import com.travelingcourier.service.BookingService;
import com.travelingcourier.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelingcourier.model.Customer;
import com.travelingcourier.service.CustomerService;


@RestController
@RequestMapping("/api/v2/customer")
public class CustomerController {

    @Autowired
    BookingService bookingService;
    @Autowired
    private CustomerService userService;
    @Autowired
    private TravellerService travellerService;

    @PostMapping("/register")
    public Customer addCustomer(@RequestBody Customer user) {
        return userService.createCustomer(user);
    }

    @GetMapping("/show/users")
    public List<Customer> getallusers() {
        return userService.getcustomers();
    }

    @GetMapping("/show/users/{customerId}")
    public Customer getCustomersById(@PathVariable int customerId) {
        return userService.getCustomersById(customerId);
    }

    @DeleteMapping("/delete/users/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        return userService.deletCustomer(customerId);
    }

    @GetMapping("/search/{departureSource}/{arrivalDestination}")
    public List<Traveller> searchForTraveller(@PathVariable String departureSource,
                                              @PathVariable String arrivalDestination
    ) {
        return travellerService.serchForTraveller(departureSource, arrivalDestination);
    }

    @GetMapping("/booking/{courier}/{customer}/{traveller}/")
    public ResponseEntity<BookingDto> bookingIntiating(@PathVariable("courier") int cu, @PathVariable("customer") Long c, @PathVariable("traveller") int t, @RequestHeader("Authorization") String bearerToken) {
        System.out.println("verification");
        BookingDto bookingDto = bookingService.getBookingById(cu, c, t, bearerToken).getBody();
        bookingService.addBooking(bookingDto);
        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id") int id) {
        System.out.println("verification");
        BookingDto bookingDto = bookingService.getBookingsById(id).getBody();

        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }


    @PutMapping("/update/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return userService.updateCustomer(customer);
    }

}

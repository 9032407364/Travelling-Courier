package com.travelingcourier.service;


import com.travelingcourier.model.BookingDto;
import com.travelingcourier.model.Courier;
import com.travelingcourier.model.Customer;
import com.travelingcourier.model.Traveller;
import com.travelingcourier.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookingService {

    @Autowired
    CourierService courierService;
    @Autowired
    CustomerService customerService;
    @Autowired
    TravellerService travellerService;
    @Autowired
    BookingRepository bookingRepository;

    public void addBooking(BookingDto book) {
        bookingRepository.save(book);
    }

    public ResponseEntity<BookingDto> getBookingById(int cu, Long c, int t, String bearerToken) {

        Courier courier = courierService.showCourierById(cu);
        Optional<Traveller> traveller = travellerService.getById(Math.toIntExact(c));
        Customer customer = customerService.getCustomersById(t);
        BookingDto bookingDto = new BookingDto();

        bookingDto.setCourier(courier);
        bookingDto.setCustomer(customer);


        if (traveller.isPresent()) {

            Traveller traveller1 = traveller.get();
            bookingDto.setTraveller(traveller1);

        }

        BookingDto bookingDto1 = bookingDto;


        return new ResponseEntity<>(bookingDto1, HttpStatus.OK);

    }

    public ResponseEntity<BookingDto> getBookingsById(int id) {
        Optional<BookingDto> bookingDto = bookingRepository.findById(id);
        return new ResponseEntity<>(bookingDto.get(), HttpStatus.OK);
    }
}


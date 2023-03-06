package com.travelingcourier.admin.service1;

import com.travelingcourier.admin.dto.BookingDto;


import com.travelingcourier.admin.entity.Traveller;
import com.travelingcourier.admin.feignclient.CourierClient;
import com.travelingcourier.admin.feignclient.CustomerClient;
import com.travelingcourier.admin.feignclient.TravellerClient;
import com.travelingcourier.admin.model1.Courier;
import com.travelingcourier.admin.model1.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;


@Service
public class BookingService {

    @Autowired
    CourierClient courierClient;

    @Autowired
    TravellerClient travellerClient;
    @Autowired
    CustomerClient customerClient;
    @Value("${file.path}")
    private String path;


    public ResponseEntity<BookingDto> getBookingByIds(int cu, Long c, int t,String bearerToken) {

        Courier courier=courierClient.showCourierById(cu,bearerToken);
        Optional<Traveller> traveller=travellerClient.getById(c,bearerToken);
        Customer customer=customerClient.getCustomersById(t,bearerToken);
        BookingDto bookingDto=new BookingDto();

        bookingDto.setCourier(courier);
        bookingDto.setCustomer(customer);


        if(traveller.isPresent()) {

            Traveller traveller1=traveller.get();
            bookingDto.setTraveller(traveller1);

        }
        BookingDto bookingDto1=bookingDto;
       // bookingRepository.save(bookingDto1);
            return new ResponseEntity<>(bookingDto1, HttpStatus.OK);

    }







    public String getBookingById(int cu, Long c, int t,String bearerToken) throws IOException {

        Courier courier=courierClient.showCourierById(cu,bearerToken);
        Optional<Traveller> traveller=travellerClient.getById(c,bearerToken);
        Customer customer=customerClient.getCustomersById(t,bearerToken);
        BookingDto bookingDto=new BookingDto();

        bookingDto.setCourier(courier);
        bookingDto.setCustomer(customer);


        if(traveller.isPresent()) {

            Traveller traveller1=traveller.get();
            bookingDto.setTraveller(traveller1);

        }
        BookingDto bookingDto1=bookingDto;

        File input = new File(path + "ReportTemplate/ProjectTemplate.html");
        Document document = Jsoup.parse(input, "UTF-8", "http://example.com/");


        Elements dom = document.children();

        Timestamp todaysTime = new Timestamp(System.currentTimeMillis());
        String value = String.valueOf(todaysTime);

        Element div = document.getElementById("reportGenaration1stDiv");
        div.html("Report Genaration Date: " + value);


        dom.select("#projectTable tbody").append("<tr><td class='tdValue'>" + bookingDto1.getTraveller().getName() + "</td><td class='tdValue'>" + bookingDto1.getTraveller().getEmail() +
                "</td><td>" +bookingDto1.getTraveller().getPhone() + "</td><td>" + bookingDto1.getTraveller().getDepartureSource() +
                "</td><td>" + bookingDto1.getTraveller().getArrivalDestination() + "</td><td>" + bookingDto1.getTraveller().getDepartureTime() + "</td></tr>");


        dom.select("#personDataTableNew tbody").append("<tr><td class='tdValue'>" + bookingDto1.getCustomer().getName() + "</td><td class='tdValue'>" + bookingDto1.getCustomer().getEmail() +
                "</td><td>" + bookingDto1.getCustomer().getPhone() + "</td><td>" + bookingDto1.getCustomer().getDepartureSource() +
                "</td><td>" + bookingDto1.getCustomer().getArrivalDestination() + "</td><td>" + bookingDto1.getCustomer().getDepartureTime() + "</td></tr>");




        String filename = "Project_Details.html";

        final File timelinereport = new File(path + "ProjectDetails/" + filename);
        FileUtils.writeStringToFile(timelinereport, String.valueOf(document), "UTF-8");

//        mailsended(traveller);

        return filename;

    }


}


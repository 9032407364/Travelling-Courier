package com.travelingcourier.admin.controller1;

import com.travelingcourier.admin.dto.BookingDto;
import com.travelingcourier.admin.entity.AdminVerification;
import com.travelingcourier.admin.service1.AdminVerificationRepository;
import com.travelingcourier.admin.service1.AdminVerificationService;
import com.travelingcourier.admin.service1.BookingRepository;
import com.travelingcourier.admin.service1.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    AdminVerificationService adminVerificationService;
    @Autowired
    private BookingService bookingService;
    @Value("${file.path}")
    private String path;

    @GetMapping("/booking/{courier}/{customer}/{traveller}/")
    public ResponseEntity<BookingDto> getBookings(@PathVariable("courier") int cu, @PathVariable("customer") Long c, @PathVariable("traveller") int t, @RequestHeader("Authorization") String bearerToken) {
        System.out.println("verification");
        BookingDto bookingDto = bookingService.getBookingByIds(cu, c, t, bearerToken).getBody();

        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }

    @GetMapping("/booking/details/{id}")
    public ResponseEntity<com.travelingcourier.admin.model1.BookingDto> getBooking(@PathVariable("id") int id) {

        System.out.println("verification");

        Optional<com.travelingcourier.admin.model1.BookingDto> bookingDto = bookingRepository.findById(id);
        System.out.println(bookingDto.get());
        return new ResponseEntity<>(bookingDto.get(), HttpStatus.OK);
    }

    @GetMapping("/payment/verification")
    public List<AdminVerification> getAll() {
        System.out.println("verification");
        List<AdminVerification> adminVerification = adminVerificationService.findAll();
        System.out.println(adminVerification);
        return adminVerification;
    }

    @PutMapping("/payment/{id}")
    public AdminVerification paymentupdate(@RequestBody AdminVerification adminVerification, @PathVariable("id") int id) {
        System.out.println("verification");
        Optional<AdminVerification> adminVerification2 = adminVerificationService.findById(id);
        AdminVerification adminVerification1 = adminVerification2.get();
        adminVerification1.setVerificationstatus(adminVerification.getVerificationstatus());
        adminVerificationService.save(adminVerification1);


        return adminVerification1;
    }


    @GetMapping("/book/{courier}/{customer}/{traveller}/")
    public ResponseEntity<String> getBookingById(@PathVariable("courier") int cu, @PathVariable("customer") Long c, @PathVariable("traveller") int t, @RequestHeader("Authorization") String bearerToken) {
        System.out.println("hi");
//        BookingDto bookingDto = bookingService.getBookingById(cu,c,t,bearerToken).getBody();
        String reportName = null;
        try {
            reportName = bookingService.getBookingById(cu, c, t, bearerToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ResponseEntity respEntity = null;

        File result = new File(path + "ProjectDetails/" + reportName);

        if (result.exists()) {
            try {
                InputStream inputStream = new FileInputStream((path + "ProjectDetails/" + reportName));
                String type = result.toURL().openConnection().guessContentTypeFromName(reportName);

                byte[] out = org.apache.commons.io.IOUtils.toByteArray(inputStream);


                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.add("content-disposition", "attachment; filename=" + reportName);
                responseHeaders.add("Content-Type", type);

                respEntity = new ResponseEntity(out, responseHeaders, HttpStatus.OK);
            } catch (IOException e) {
                System.out.println(e.fillInStackTrace());
            }
        } else {
            respEntity = new ResponseEntity("File Not Found", HttpStatus.OK);
        }


        return respEntity;
    }
}



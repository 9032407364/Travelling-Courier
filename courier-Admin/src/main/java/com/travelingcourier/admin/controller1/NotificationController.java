package com.travelingcourier.admin.controller1;

import com.travelingcourier.admin.dto.EmailDetails;
import com.travelingcourier.admin.service1.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    public String message() {
        return "hello";
    }


    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetails details) {
        String status
                = emailService.sendSimpleMail(details);
        return status;
    }

    @PostMapping("/sendMail/attachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details) throws MessagingException {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }

    @PostMapping("/dispatched")
    public String dispatchedApi(@RequestBody EmailDetails details) {
        String status
                = emailService.dispatchedMail(details);
        return status;
    }

    @PostMapping("/handover")
    public String handoverTheParcel(@RequestBody EmailDetails details) {
        String status
                = emailService.handOver(details);
        return status;
    }

}

package com.travelingcourier.admin.service1;


import com.travelingcourier.admin.dto.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public String sendSimpleMail(EmailDetails details) {

        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            String body = "Dear Recipient,\n" +
                    "\n" +
                    "Greetings !!!\n" +
                    "\n" +
                    "Welcome to the Traveller & Currier Service \n" +
                    "\n" +
                    "This is an automated email powered by Traveller & Currier Service from UST. Please do not reply to this email.\n" +
                    "\n" +
                    "\n" +
                    "Best Regards,\n" +
                    "Team TCS" +
                    "\n";

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(body);
            mailMessage.setSubject(details.getSubject());
            mailMessage.setCc(details.getCc());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail" + e;
        }
    }

    // Method 2
    // To send an email with attachment
    public String
    sendMailWithAttachment(EmailDetails details) throws MessagingException {
        // Creating a mime message
        System.out.println("I am here");
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            String body = "Dear Recipient,\n" +
                    "\n" +
                    "Greetings !!!\n" +
                    "\n" +
                    "Welcome to the Traveller & Currier Service \n" +
                    "\n" +
                    "This is an automated email powered by Traveller & Currier Service from UST. Please do not reply to this email.\n" +
                    "\n" +
                    "\n" +
                    "Best Regards,\n" +
                    "Team TCS" +
                    "\n";

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(
                    details.getSubject());
            mimeMessageHelper.setCc(details.getCc());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!" + e;
        }
    }

    public String dispatchedMail(EmailDetails details) {

        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            String body = "Dear Recipient,\n" +
                    "\n" +
                    "Greetings !!!\n" +
                    "\n" +
                    "Thank you so much for choosing Traveller & Currier Service for your delivary partner \n" +
                    "\n" +
                    "We are happy to inform you that your order has successfully dispatched \n" +
                    "\n" +
                    "This is an automated email powered by Traveller & Currier Service from UST. Please do not reply to this email.\n" +
                    "\n" +
                    "\n" +
                    "Best Regards,\n" +
                    "Team TCS" +
                    "\n";

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(body);
            mailMessage.setSubject(details.getSubject());
            mailMessage.setCc(details.getCc());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail" + e;
        }
    }

    public String handOver(EmailDetails details) {

        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            String body = "Dear Recipient,\n" +
                    "\n" +
                    "Greetings !!!\n" +
                    "\n" +
                    "Thank you so much for choosing Traveller & Currier Service for your delivary partner \n" +
                    "\n" +
                    "Please hand over the parcel to the traveller and contact him with the provided details \n" +
                    "\n" +
                    "This is an automated email powered by Traveller & Currier Service from UST. Please do not reply to this email.\n" +
                    "\n" +
                    "\n" +
                    "Best Regards,\n" +
                    "Team TCS" +
                    "\n";

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(body);
            mailMessage.setSubject(details.getSubject());
            mailMessage.setCc(details.getCc());

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail" + e;
        }
    }
}

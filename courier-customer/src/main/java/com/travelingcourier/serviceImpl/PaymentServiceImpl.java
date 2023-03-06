package com.travelingcourier.serviceImpl;


import com.travelingcourier.exception.PaymentServiceCustomException;
import com.travelingcourier.model.AdminVerification;
import com.travelingcourier.model.PaymentRequest;
import com.travelingcourier.model.PaymentResponse;
import com.travelingcourier.model.TransactionDetails;
import com.travelingcourier.repo.TransactionDetailsRepository;
import com.travelingcourier.repository.AdminVerificationRepository;
import com.travelingcourier.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	@Autowired
    public TransactionDetailsRepository transactionDetailsRepository;
@Autowired
    AdminVerificationRepository adminVerificationRepository;
    @Override
    public TransactionDetails doPayment(PaymentRequest paymentRequest) {

       

        TransactionDetails transactionDetails
                = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(generate())
                .customerId(paymentRequest.getCustomerId())
                .amount(paymentRequest.getAmount()).booking(paymentRequest.getBookingId())
                .build();

        transactionDetails = transactionDetailsRepository.save(transactionDetails);

        AdminVerification adminVerification = new AdminVerification();
        adminVerification.setPaymentId((int) transactionDetails.getPaymentId());
        adminVerification.setBookingId(transactionDetails.getBooking());
        adminVerificationRepository.save(adminVerification);

        
        return transactionDetails;
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(long orderId) {

        

        TransactionDetails transactionDetails
                = transactionDetailsRepository.findByOrderId(orderId)
                .orElseThrow(() -> new PaymentServiceCustomException(
                        "TransactionDetails with given id not found",
                        "TRANSACTION_NOT_FOUND"));

        PaymentResponse paymentResponse
                = PaymentResponse.builder()
                .paymentId(transactionDetails.getPaymentId())
                .paymentMode(transactionDetails.getPaymentMode())
                .paymentDate(transactionDetails.getPaymentDate())
                .orderId(transactionDetails.getOrderId())
                .status(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();

      

        return paymentResponse;
    } 
    
    public static String generate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        return timestamp + randomNumber;
    }
}

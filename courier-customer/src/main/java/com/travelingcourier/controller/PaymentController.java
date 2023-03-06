package com.travelingcourier.controller;


import com.travelingcourier.model.PaymentRequest;
import com.travelingcourier.model.PaymentResponse;
import com.travelingcourier.model.TransactionDetails;
import com.travelingcourier.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
@Log4j2
public class PaymentController {
    @Autowired
    public PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<TransactionDetails> doPayment(@RequestBody PaymentRequest paymentRequest) {


        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.OK
        );
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable long orderId) {


        return new ResponseEntity<>(
                paymentService.getPaymentDetailsByOrderId(orderId),
                HttpStatus.OK
        );
    }
}

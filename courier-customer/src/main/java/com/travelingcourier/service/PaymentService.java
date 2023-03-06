package com.travelingcourier.service;


import com.travelingcourier.model.PaymentRequest;
import com.travelingcourier.model.PaymentResponse;
import com.travelingcourier.model.TransactionDetails;

public interface PaymentService {
    TransactionDetails doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}

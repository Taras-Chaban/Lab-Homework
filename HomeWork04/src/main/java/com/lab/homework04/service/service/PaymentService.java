package com.lab.homework04.service.service;

import com.lab.homework04.service.dto.PaymentDto;

public interface PaymentService {
    PaymentDto getPayment(String productCode);

    PaymentDto createPayment(PaymentDto paymentDto);

    PaymentDto updatePayment(String productCode, PaymentDto paymentDto);

    void deletePayment(String productCode);
}

package com.lab.homework5.service.controller;


import com.lab.homework5.service.dto.PaymentDto;
import com.lab.homework5.service.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController implements com.lab.homework5.service.api.PaymentApi {
    private final PaymentServiceImpl paymentService;

    @Override
    public PaymentDto getPayment(String productCode) {
        log.info("Getting payment with productCode {}", productCode);
        return paymentService.getPayment(productCode);
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        log.info("Creating payment {}", paymentDto);
        return paymentService.createPayment(paymentDto);
    }

    @Override
    public PaymentDto updatePayment(String productCode, PaymentDto paymentDto) {
        log.info("Updating payment with productCode {}", productCode);
        return paymentService.updatePayment(productCode, paymentDto);
    }

    @Override
    public ResponseEntity<Void> deletePayment(String productCode) {
        paymentService.deletePayment(productCode);
        return ResponseEntity.noContent().build();
    }
}

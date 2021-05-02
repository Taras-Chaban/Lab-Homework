package com.lab.homework5.service.controller;


import com.lab.homework5.service.api.PaymentApi;
import com.lab.homework5.service.controller.assembler.PaymentAssembler;
import com.lab.homework5.service.controller.model.PaymentModel;
import com.lab.homework5.service.dto.PaymentDto;
import com.lab.homework5.service.service.impl.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController implements PaymentApi {
    private final PaymentServiceImpl paymentService;
    private final PaymentAssembler paymentAssembler;

    @Override
    public PaymentModel getPayment(String productCode) {
        log.info("Getting payment with productCode {}", productCode);
        PaymentDto paymentDto = paymentService.getPayment(productCode);
        return paymentAssembler.toModel(paymentDto);
    }

    @Override
    public PaymentModel createPayment(PaymentDto paymentDto) {
        log.info("Creating payment {}", paymentDto);
        PaymentDto resultPaymentDto = paymentService.createPayment(paymentDto);
        return paymentAssembler.toModel(resultPaymentDto);
    }

    @Override
    public PaymentModel updatePayment(String productCode, PaymentDto paymentDto) {
        log.info("Updating payment with productCode {}", productCode);
        PaymentDto resultPaymentDto = paymentService.updatePayment(productCode, paymentDto);
        return paymentAssembler.toModel(resultPaymentDto);
    }

    @Override
    public ResponseEntity<Void> deletePayment(String productCode) {
        paymentService.deletePayment(productCode);
        return ResponseEntity.noContent().build();
    }
}

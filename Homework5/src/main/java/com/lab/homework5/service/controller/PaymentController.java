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
public class PaymentController {
    private final PaymentServiceImpl paymentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{productCode}")
    public PaymentDto getPayment(@PathVariable String productCode) {
        log.info("Getting payment with productCode {}", productCode);
        return paymentService.getPayment(productCode);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto) {
        log.info("Creating payment {}", paymentDto);
        return paymentService.createPayment(paymentDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{productCode}")
    public PaymentDto updatePayment(@PathVariable String productCode, @RequestParam PaymentDto paymentDto) {
        log.info("Updating payment with productCode {}", productCode);
        return paymentService.updatePayment(productCode, paymentDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{productCode}")
    public ResponseEntity<Void> deletePayment(@PathVariable String productCode) {
        paymentService.deletePayment(productCode);
        return ResponseEntity.noContent().build();
    }
}

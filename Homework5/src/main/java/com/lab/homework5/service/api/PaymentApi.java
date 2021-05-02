package com.lab.homework5.service.api;

import com.lab.homework5.service.dto.PaymentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PaymentApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{productCode}")
    PaymentDto getPayment(@PathVariable String productCode);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    PaymentDto createPayment(@RequestBody PaymentDto paymentDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{productCode}")
    PaymentDto updatePayment(@PathVariable String productCode, @RequestParam PaymentDto paymentDto);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{productCode}")
    ResponseEntity<Void> deletePayment(@PathVariable String productCode);
}

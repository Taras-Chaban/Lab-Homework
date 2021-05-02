package com.lab.homework5.service.api;

import com.lab.homework5.service.dto.InvoiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface InvoiceApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    InvoiceDto getInvoice(@PathVariable Long code);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{code}")
    InvoiceDto updateInvoice(@PathVariable Long code, @RequestParam InvoiceDto invoiceDto);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code}")
    ResponseEntity<Void> deleteInvoice(@PathVariable Long code);
}

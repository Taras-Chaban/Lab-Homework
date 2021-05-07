package com.lab.homework6.service.api;

import com.lab.homework6.service.controller.model.InvoiceModel;
import com.lab.homework6.service.dto.InvoiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface InvoiceApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    InvoiceModel getInvoice(@PathVariable Long code);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    InvoiceModel createInvoice(@RequestBody InvoiceDto invoiceDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{code}")
    InvoiceModel updateInvoice(@PathVariable Long code, @RequestParam InvoiceDto invoiceDto);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code}")
    ResponseEntity<Void> deleteInvoice(@PathVariable Long code);
}

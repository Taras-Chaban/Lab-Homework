package com.lab.homework04.service.controller;

import com.lab.homework04.service.dto.InvoiceDto;
import com.lab.homework04.service.service.impl.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/{invoices}")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceServiceImpl invoiceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{code}")
    public InvoiceDto getInvoice(@PathVariable Long code) {
        log.info("Getting invoice with code {}", code);
        return invoiceService.getInvoice(code);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto) {
        log.info("Creating invoice {}", invoiceDto);
        return invoiceService.createInvoice(invoiceDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{code}")
    public InvoiceDto updateInvoice(@PathVariable Long code, @RequestParam InvoiceDto invoiceDto) {
        log.info("Updating invoice with code {}", code);
        return invoiceService.updateInvoice(code, invoiceDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long code) {
        log.info("Deleting invoice with code {}", code);
        invoiceService.deleteInvoice(code);
        return ResponseEntity.noContent().build();
    }
}

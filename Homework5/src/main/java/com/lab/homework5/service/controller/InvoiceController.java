package com.lab.homework5.service.controller;

import com.lab.homework5.service.api.InvoiceApi;
import com.lab.homework5.service.dto.InvoiceDto;
import com.lab.homework5.service.service.impl.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController implements InvoiceApi {
    private final InvoiceServiceImpl invoiceService;

    @Override
    public InvoiceDto getInvoice(Long code) {
        log.info("Getting invoice with code {}", code);
        return invoiceService.getInvoice(code);
    }

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        log.info("Creating invoice {}", invoiceDto);
        return invoiceService.createInvoice(invoiceDto);
    }

    @Override
    public InvoiceDto updateInvoice(Long code, InvoiceDto invoiceDto) {
        log.info("Updating invoice with code {}", code);
        return invoiceService.updateInvoice(code, invoiceDto);
    }

    @Override
    public ResponseEntity<Void> deleteInvoice(Long code) {
        log.info("Deleting invoice with code {}", code);
        invoiceService.deleteInvoice(code);
        return ResponseEntity.noContent().build();
    }
}

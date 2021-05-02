package com.lab.homework5.service.controller;

import com.lab.homework5.service.api.InvoiceApi;
import com.lab.homework5.service.controller.assembler.InvoiceAssembler;
import com.lab.homework5.service.controller.model.InvoiceModel;
import com.lab.homework5.service.dto.InvoiceDto;
import com.lab.homework5.service.service.impl.InvoiceServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController implements InvoiceApi {
    private final InvoiceServiceImpl invoiceService;
    private final InvoiceAssembler invoiceAssembler;

    @Override
    public InvoiceModel getInvoice(Long code) {
        log.info("Getting invoice with code {}", code);
        InvoiceDto invoiceDto = invoiceService.getInvoice(code);
        return invoiceAssembler.toModel(invoiceDto);
    }

    @Override
    public InvoiceModel createInvoice(InvoiceDto invoiceDto) {
        log.info("Creating invoice {}", invoiceDto);
        InvoiceDto resultInvoiceDto = invoiceService.createInvoice(invoiceDto);
        return invoiceAssembler.toModel(resultInvoiceDto);
    }

    @Override
    public InvoiceModel updateInvoice(Long code, InvoiceDto invoiceDto) {
        log.info("Updating invoice with code {}", code);
        InvoiceDto resultInvoiceDto = invoiceService.updateInvoice(code, invoiceDto);
        return invoiceAssembler.toModel(resultInvoiceDto);
    }

    @Override
    public ResponseEntity<Void> deleteInvoice(Long code) {
        log.info("Deleting invoice with code {}", code);
        invoiceService.deleteInvoice(code);
        return ResponseEntity.noContent().build();
    }
}

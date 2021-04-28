package com.lab.homework04.service.service;

import com.lab.homework04.service.dto.InvoiceDto;

public interface InvoiceService {
    InvoiceDto getInvoice(Long code);

    InvoiceDto createInvoice(InvoiceDto invoiceDto);

    InvoiceDto updateInvoice(Long code, InvoiceDto invoiceDto);

    void deleteInvoice(Long code);
}

package com.lab.homework5.service.service;

import com.lab.homework5.service.dto.InvoiceDto;

public interface InvoiceService {
    InvoiceDto getInvoice(Long code);

    InvoiceDto createInvoice(InvoiceDto invoiceDto);

    InvoiceDto updateInvoice(Long code, InvoiceDto invoiceDto);

    void deleteInvoice(Long code);
}

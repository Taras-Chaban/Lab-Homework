package com.lab.homework04.service.repository;

import com.lab.homework04.service.model.Invoice;

public interface InvoiceRepository {
    Invoice getInvoice(Long code);

    Invoice createInvoice(Invoice invoice);

    Invoice updateInvoice(Long code, Invoice invoice);

    void deleteInvoice(Long code);
}

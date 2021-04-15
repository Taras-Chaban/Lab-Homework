package com.lab.homework04.service.repository.impl;

import com.lab.homework04.service.model.Invoice;
import com.lab.homework04.service.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class InvoiceRepositoryImpl implements InvoiceRepository {
    private final List<Invoice> invoices = new ArrayList<>();

    @Override
    public Invoice getInvoice(Long code) {
        Invoice invoice = invoices.stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        log.info("Get invoice {}", invoice);
        return invoice;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoices.add(invoice);
        log.info("Created invoice {}", invoice);
        return invoice;
    }

    @Override
    public Invoice updateInvoice(Long code, Invoice invoice) {
        boolean isDeleted = invoices.removeIf(i -> i.getCode().equals(code));
        if (isDeleted) {
            invoices.add(invoice);
            log.info("Updated invoice {}", invoice);
        } else {
            throw new RuntimeException("Invoice does not exist");
        }
        return invoice;
    }

    @Override
    public void deleteInvoice(Long code) {
        boolean isDeleted = invoices.removeIf(i -> i.getCode().equals(code));
        if (isDeleted) {
            log.info("Deleted invoice with code {}", code);
        } else {
            throw new RuntimeException("Invoice does not exist");
        }
    }
}

package com.lab.homework5.service.service.impl;

import com.lab.homework5.service.dto.InvoiceDto;
import com.lab.homework5.service.model.Invoice;
import com.lab.homework5.service.repository.impl.InvoiceRepositoryImpl;
import com.lab.homework5.service.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepositoryImpl invoiceRepository;

    @Override
    public InvoiceDto getInvoice(Long code) {
        return mapInvoiceToInvoiceDto(invoiceRepository.getInvoice(code));
    }

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceRepository.createInvoice(mapInvoiceDtoToInvoice(invoiceDto));
        return mapInvoiceToInvoiceDto(invoice);
    }

    @Override
    public InvoiceDto updateInvoice(Long code, InvoiceDto invoiceDto) {
        Invoice invoice = mapInvoiceDtoToInvoice(invoiceDto);
        return mapInvoiceToInvoiceDto(invoiceRepository.updateInvoice(code, invoice));
    }

    @Override
    public void deleteInvoice(Long code) {
        invoiceRepository.deleteInvoice(code);
    }

    private Invoice mapInvoiceDtoToInvoice(InvoiceDto invoiceDto) {
        return Invoice.builder()
                .code(invoiceDto.getCode())
                .date(invoiceDto.getDate())
                .isPaid(invoiceDto.getIsPaid())
                .price(invoiceDto.getPrice())
                .userName(invoiceDto.getUserName())
                .build();
    }

    private InvoiceDto mapInvoiceToInvoiceDto(Invoice invoice) {
        return InvoiceDto.builder()
                .code(invoice.getCode())
                .date(invoice.getDate())
                .isPaid(invoice.getIsPaid())
                .price(invoice.getPrice())
                .userName(invoice.getUserName())
                .build();
    }
}

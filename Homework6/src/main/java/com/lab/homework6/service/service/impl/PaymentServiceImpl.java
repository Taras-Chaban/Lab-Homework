package com.lab.homework6.service.service.impl;

import com.lab.homework6.service.dto.PaymentDto;
import com.lab.homework6.service.model.Payment;
import com.lab.homework6.service.repository.impl.PaymentRepositoryImpl;
import com.lab.homework6.service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepositoryImpl paymentRepository;

    @Override
    public PaymentDto getPayment(String productCode) {
        return mapPaymentToPaymentDto(paymentRepository.getPayment(productCode));
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = paymentRepository.createPayment(mapPaymentDtoToPayment(paymentDto));
        return mapPaymentToPaymentDto(payment);
    }

    @Override
    public PaymentDto updatePayment(String productCode, PaymentDto paymentDto) {
        Payment payment = paymentRepository.updatePayment(productCode, mapPaymentDtoToPayment(paymentDto));
        return mapPaymentToPaymentDto(payment);
    }

    @Override
    public void deletePayment(String productCode) {
        paymentRepository.deletePayment(productCode);
    }

    private PaymentDto mapPaymentToPaymentDto(Payment payment) {
        return PaymentDto.builder()
                .productCode(payment.getProductCode())
                .invoiceCode(payment.getInvoiceCode())
                .productName(payment.getProductName())
                .quantity(payment.getQuantity())
                .value(payment.getValue())
                .build();
    }

    private Payment mapPaymentDtoToPayment(PaymentDto paymentDto) {
        return Payment.builder()
                .productCode(paymentDto.getProductCode())
                .invoiceCode(paymentDto.getInvoiceCode())
                .productName(paymentDto.getProductName())
                .quantity(paymentDto.getQuantity())
                .value(paymentDto.getValue())
                .build();
    }
}

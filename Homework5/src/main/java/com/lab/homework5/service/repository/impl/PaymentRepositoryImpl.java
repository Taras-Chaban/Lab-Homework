package com.lab.homework5.service.repository.impl;

import com.lab.homework5.service.exception.PaymentNotFoundException;
import com.lab.homework5.service.model.Payment;
import com.lab.homework5.service.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PaymentRepositoryImpl implements PaymentRepository {
    private final List<Payment> paymentList = new ArrayList<>();

    @Override
    public Payment getPayment(String productCode) {
        Payment resultPayment = paymentList.stream()
                .filter(payment -> payment.getProductCode().equals(productCode))
                .findFirst()
                .orElseThrow(PaymentNotFoundException::new);
        log.info("Got payment {}", resultPayment);
        return resultPayment;
    }

    @Override
    public Payment createPayment(Payment payment) {
        paymentList.add(payment);
        log.info("Created payment {}", payment);
        return payment;
    }

    @Override
    public Payment updatePayment(String productCode, Payment payment) {
        boolean isDeleted = paymentList.removeIf(p -> p.getProductCode().equals(productCode));
        if (isDeleted) {
            paymentList.add(payment);
            log.info("Updated payment {}", payment);
            return payment;
        } else {
            throw new RuntimeException("Payment does not exist");
        }
    }

    @Override
    public void deletePayment(String productCode) {
        boolean isDeleted = paymentList.removeIf(p -> p.getProductCode().equals(productCode));
        if (isDeleted) {
            log.info("Deleted payment with productCode {}", productCode);
        } else {
            throw new RuntimeException("Payment does not exist");
        }
    }
}

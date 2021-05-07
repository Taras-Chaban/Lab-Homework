package com.lab.homework6.service.repository;

import com.lab.homework6.service.model.Payment;

public interface PaymentRepository {
    Payment getPayment(String productCode);

    Payment createPayment(Payment payment);

    Payment updatePayment(String productCode, Payment payment);

    void deletePayment(String productCode);
}

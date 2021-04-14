package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {
    private Long invoiceCode;
    private String productCode;
    private String productName;
    private Double quantity;
    private Double value;
}

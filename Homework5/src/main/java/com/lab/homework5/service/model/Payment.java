package com.lab.homework04.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment {
    private Long invoiceCode;
    private String productCode;
    private String productName;
    private Double quantity;
    private Double value;
}

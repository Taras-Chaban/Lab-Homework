package com.lab.homework5.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String code;
    private Boolean isAvailable;
    private String name;
    private String description;
    private Double cost;
    private Double quantity;
    private Double reservedQuantity;
}

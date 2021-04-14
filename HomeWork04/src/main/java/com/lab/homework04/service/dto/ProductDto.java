package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String code;
    private Boolean isAvailable;
    private String name;
    private String description;
    private Double cost;
    private Double quantity;
    private Double reservedQuantity;
}

package com.lab.homework04.service.model;

import lombok.Data;

@Data
public class Product {
    private String code;
    private Boolean isAvailable;
    private String name;
    private String description;
    private Double cost;
    private Double quantity;
    private Double reservedQuantity;
}

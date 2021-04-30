package com.lab.homework5.service.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Invoice {
    private Long code;
    private String userName;
    private Boolean isPaid;
    private Timestamp date;
    private Double price;
}

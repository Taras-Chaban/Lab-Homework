package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class InvoiceDto {
    private Long code;
    private String userName;
    private Boolean isPaid;
    private Timestamp date;
    private Double price;
}

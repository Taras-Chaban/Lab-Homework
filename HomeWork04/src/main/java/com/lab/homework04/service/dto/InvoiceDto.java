package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
public class InvoiceDto {
    @NotNull
    @Size(min = 5, max = 5)
    private Long code;

    @NotNull
    private String userName;
    private Boolean isPaid;

    @NotNull
    private Timestamp date;

    @NotNull
    @PositiveOrZero
    private Double price;
}

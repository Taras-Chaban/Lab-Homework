package com.lab.homework6.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

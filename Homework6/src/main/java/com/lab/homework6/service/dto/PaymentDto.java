package com.lab.homework6.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    @NotNull
    @Size(min = 5, max = 5)
    private Long invoiceCode;

    @NotNull
    @Size(min = 6, max = 6)
    private String productCode;

    @NotNull
    private String productName;

    @Positive
    private Double quantity;

    @PositiveOrZero
    private Double value;
}

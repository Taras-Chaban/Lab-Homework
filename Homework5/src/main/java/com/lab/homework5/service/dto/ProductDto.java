package com.lab.homework5.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotNull
    @Size(min = 6, max = 6)
    private String code;

    @NotNull
    private Boolean isAvailable;

    @NotNull
    private String name;
    private String description;

    @NotNull
    @Positive
    private Double cost;

    @NotNull
    @Positive
    private Double quantity;

    @NotNull
    @Positive
    private Double reservedQuantity;
}

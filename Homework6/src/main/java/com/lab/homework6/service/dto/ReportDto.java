package com.lab.homework6.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    @NotNull
    @Size(min = 1, max = 1)
    private String reportType;

    @NotNull
    private Timestamp date;

    @Positive
    @NotNull
    private Integer cashBefore;

    @Positive
    @NotNull
    private Integer cashAfter;

    @Positive
    @NotNull
    private Integer currentCash;
}

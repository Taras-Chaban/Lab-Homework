package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Builder
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

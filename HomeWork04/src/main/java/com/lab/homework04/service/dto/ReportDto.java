package com.lab.homework04.service.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ReportDto {
    private String reportType;
    private Timestamp date;
    private Integer cashBefore;
    private Integer cashAfter;
    private Integer currentCash;
}

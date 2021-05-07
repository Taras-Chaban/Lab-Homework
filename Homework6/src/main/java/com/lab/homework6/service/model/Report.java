package com.lab.homework6.service.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Report {
    private String reportType;
    private Timestamp date;
    private Integer cashBefore;
    private Integer cashAfter;
    private Integer currentCash;
}

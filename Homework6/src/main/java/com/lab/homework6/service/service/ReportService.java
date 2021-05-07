package com.lab.homework6.service.service;

import com.lab.homework6.service.dto.ReportDto;

import java.sql.Timestamp;

public interface ReportService {
    ReportDto getReport(Timestamp time);

    ReportDto createReport(ReportDto reportDto);

    void deleteReport(Timestamp time);
}

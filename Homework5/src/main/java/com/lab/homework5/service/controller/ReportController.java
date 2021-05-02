package com.lab.homework5.service.controller;

import com.lab.homework5.service.dto.ReportDto;
import com.lab.homework5.service.service.impl.ReportServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/reports")
@RequiredArgsConstructor
public class ReportController implements com.lab.homework5.service.api.ReportApi {
    private final ReportServiceImpl reportService;

    @Override
    public ReportDto getReport(Timestamp time) {
        log.info("Getting report with time {}", time);
        return reportService.getReport(time);
    }

    @Override
    public ReportDto createReport(ReportDto reportDto) {
        log.info("Creating report {}", reportDto);
        return reportService.createReport(reportDto);
    }

    @Override
    public ResponseEntity<Void> deleteReport(Timestamp time) {
        log.info("Deleting report with time {}", time);
        reportService.deleteReport(time);
        return ResponseEntity.noContent().build();
    }
}

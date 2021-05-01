package com.lab.homework5.service.controller;

import com.lab.homework5.service.dto.ReportDto;
import com.lab.homework5.service.service.impl.ReportServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportServiceImpl reportService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{time}")
    public ReportDto getReport(@PathVariable Timestamp time) {
        log.info("Getting report with time {}", time);
        return reportService.getReport(time);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReportDto createReport(@RequestBody ReportDto reportDto) {
        log.info("Creating report {}", reportDto);
        return reportService.createReport(reportDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{time}")
    public ResponseEntity<Void> deleteReport(@PathVariable Timestamp time) {
        log.info("Deleting report with time {}", time);
        reportService.deleteReport(time);
        return ResponseEntity.noContent().build();
    }
}

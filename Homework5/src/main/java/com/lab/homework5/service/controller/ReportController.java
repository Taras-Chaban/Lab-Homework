package com.lab.homework5.service.controller;

import com.lab.homework5.service.api.ReportApi;
import com.lab.homework5.service.controller.assembler.ReportAssembler;
import com.lab.homework5.service.controller.model.ReportModel;
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
public class ReportController implements ReportApi {
    private final ReportServiceImpl reportService;
    private final ReportAssembler reportAssembler;

    @Override
    public ReportModel getReport(Timestamp time) {
        log.info("Getting report with time {}", time);
        ReportDto reportDto = reportService.getReport(time);
        return reportAssembler.toModel(reportDto);
    }

    @Override
    public ReportModel createReport(ReportDto reportDto) {
        log.info("Creating report {}", reportDto);
        ReportDto resultReportDto = reportService.createReport(reportDto);
        return reportAssembler.toModel(resultReportDto);
    }

    @Override
    public ResponseEntity<Void> deleteReport(Timestamp time) {
        log.info("Deleting report with time {}", time);
        reportService.deleteReport(time);
        return ResponseEntity.noContent().build();
    }
}

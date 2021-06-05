package com.lab.homework6.service.service.impl;

import com.lab.homework6.service.dto.ReportDto;
import com.lab.homework6.service.exception.ReportNotFoundException;
import com.lab.homework6.service.model.Report;
import com.lab.homework6.service.repository.ReportRepository;
import com.lab.homework6.service.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public ReportDto getReport(Timestamp time) {
        Report report = reportRepository.findByDate(time).orElseThrow(ReportNotFoundException::new);
        log.info("Got Report from DB {}", report);
        return mapReportToReportDto(report);
    }

    @Override
    public ReportDto createReport(ReportDto reportDto) {
        Report report = mapReportDtoToReport(reportDto);

        mapReportToReportDto(reportRepository.save(report));
        return null;
    }

    @Override
    public void deleteReport(Timestamp time) {
        reportRepository.deleteReport(time);
    }

    public ReportDto mapReportToReportDto(Report report) {
        return ReportDto.builder()
                .reportType(report.getReportType())
                .date(report.getDate())
                .cashBefore(report.getCashBefore())
                .cashAfter(report.getCashAfter())
                .currentCash(report.getCurrentCash())
                .build();
    }

    public Report mapReportDtoToReport(ReportDto reportDto) {
        return Report.builder()
                .reportType(reportDto.getReportType())
                .date(reportDto.getDate())
                .cashBefore(reportDto.getCashBefore())
                .cashAfter(reportDto.getCashAfter())
                .currentCash(reportDto.getCurrentCash())
                .build();
    }

}

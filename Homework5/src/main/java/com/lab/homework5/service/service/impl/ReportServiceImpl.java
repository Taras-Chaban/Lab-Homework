package com.lab.homework5.service.service.impl;

import com.lab.homework5.service.dto.ReportDto;
import com.lab.homework5.service.model.Report;
import com.lab.homework5.service.repository.impl.ReportRepositoryImpl;
import com.lab.homework5.service.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepositoryImpl reportRepository;

    @Override
    public ReportDto getReport(Timestamp time) {
        return mapReportToReportDto(reportRepository.getReport(time));
    }

    @Override
    public ReportDto createReport(ReportDto reportDto) {
        Report report = mapReportDtoToReport(reportDto);
        return mapReportToReportDto(reportRepository.createReport(report));
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

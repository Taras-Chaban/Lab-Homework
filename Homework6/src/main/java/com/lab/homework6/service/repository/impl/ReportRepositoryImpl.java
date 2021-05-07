package com.lab.homework6.service.repository.impl;

import com.lab.homework6.service.exception.ReportNotFoundException;
import com.lab.homework6.service.model.Report;
import com.lab.homework6.service.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ReportRepositoryImpl implements ReportRepository {
    private final List<Report> reportList = new ArrayList<>();

    @Override
    public Report getReport(Timestamp time) {
        Report resultReport = reportList.stream()
                .filter(report -> report.getDate().equals(time))
                .findFirst()
                .orElseThrow(ReportNotFoundException::new);
        log.info("Get report {}", time);
        return resultReport;
    }

    @Override
    public Report createReport(Report report) {
        reportList.add(report);
        log.info("Created report {}", report);
        return report;
    }

    @Override
    public void deleteReport(Timestamp time) {
        boolean isDeleted = reportList.removeIf(report -> report.getDate().equals(time));
        if (!isDeleted) {
            log.info("Report with time {} does not exist", time);
            throw new RuntimeException("Report does not exist");
        } else {
            log.info("Report with time {} was deleted", time);
        }
    }
}

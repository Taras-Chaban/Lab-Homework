package com.lab.homework6.service.repository;

import com.lab.homework6.service.model.Report;

import java.sql.Timestamp;

public interface ReportRepository {
    Report getReport(Timestamp time);

    Report createReport(Report report);

    void deleteReport(Timestamp time);
}

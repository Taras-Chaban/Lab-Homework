package com.lab.homework6.service.repository;

import com.lab.homework6.service.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {

    Optional<Report> findByDate(Timestamp time);

    Report createReport(Report report);

    void deleteReport(Timestamp time);
}

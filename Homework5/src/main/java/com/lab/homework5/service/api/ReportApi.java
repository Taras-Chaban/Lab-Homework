package com.lab.homework5.service.api;

import com.lab.homework5.service.controller.model.ReportModel;
import com.lab.homework5.service.dto.ReportDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

public interface ReportApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{time}")
    ReportModel getReport(@PathVariable Timestamp time);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ReportModel createReport(@RequestBody ReportDto reportDto);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{time}")
    ResponseEntity<Void> deleteReport(@PathVariable Timestamp time);
}

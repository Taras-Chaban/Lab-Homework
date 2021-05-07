package com.lab.homework6.service.exception;

import com.lab.homework6.service.model.enums.ErrorType;

public class ReportNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Report not found!";

    public ReportNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ReportNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

package com.lab.homework5.service.exception;

import com.lab.homework5.service.model.enums.ErrorType;

public class InvoiceNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Invoice not found!";

    public InvoiceNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public InvoiceNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

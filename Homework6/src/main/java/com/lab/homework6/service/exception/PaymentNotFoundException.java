package com.lab.homework6.service.exception;

import com.lab.homework6.service.model.enums.ErrorType;

public class PaymentNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Payment not found!";

    public PaymentNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PaymentNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

package com.lab.homework6.service.exception;

import com.lab.homework6.service.model.enums.ErrorType;

public class ProductNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Product not found!";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}

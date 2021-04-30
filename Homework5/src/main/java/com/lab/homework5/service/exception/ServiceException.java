package com.lab.homework5.service.exception;

import com.lab.homework5.service.model.enums.ErrorType;
import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    private ErrorType errorType;

    public ServiceException(String message) {
        super(message);
    }

    public ErrorType getErrorType() {
        return errorType;
    }

}

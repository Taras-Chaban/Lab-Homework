package com.lab.homework5.service.controller;

import com.lab.homework5.service.exception.ServiceException;
import com.lab.homework5.service.model.Error;
import com.lab.homework5.service.model.enums.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("handleMethodArgumentNotValidException: message {}", ex.getMessage());
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(err -> new Error(
                        err.getDefaultMessage(),
                        ErrorType.VALIDATION_ERROR_TYPE,
                        LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleServiceException(ServiceException exception) {
        log.error("handleServiceException: message {}", exception.getMessage());
        return new Error(exception.getMessage(), exception.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(Exception exception) {
        log.error("handleException: message {}", exception.getMessage());
        return new Error(exception.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }

}

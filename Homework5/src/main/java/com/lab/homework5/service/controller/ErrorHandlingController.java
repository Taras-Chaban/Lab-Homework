package com.lab.homework5.service.controller;

import com.lab.homework5.service.exception.UserNotFoundException;
import com.lab.homework5.service.model.Error;
import com.lab.homework5.service.model.enums.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleUserNotFoundException(UserNotFoundException exception) {
        return new Error(exception.getMessage(), ErrorType.DATABASE_ERROR_TYPE, LocalDateTime.now());
    }


}

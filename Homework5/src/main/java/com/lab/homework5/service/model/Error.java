package com.lab.homework5.service.model;

import com.lab.homework5.service.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String message;
    private ErrorType errorType;
    private String timeStamp;
}

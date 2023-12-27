package com.soapandrest.SoapAndRestApi.rest.controller;

import com.soapandrest.SoapAndRestApi.rest.model.BaseReponseFailed;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseReponseFailed> constrainViolation(ConstraintViolationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(BaseReponseFailed.builder().errors(exception.getMessage()).build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<BaseReponseFailed> apiException(ResponseStatusException exception){
        return ResponseEntity.status(exception.getStatusCode())
                .body(BaseReponseFailed.builder().errors(exception.getReason()).build());
    }
}

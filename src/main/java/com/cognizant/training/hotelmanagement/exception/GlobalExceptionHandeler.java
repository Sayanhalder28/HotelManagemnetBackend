package com.cognizant.training.hotelmanagement.exception;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String IllegalArgumentExceptionHandeler(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String MissingServletRequestParameterExceptionHandeler(Exception e) {
        return "Mandetory fields are missing";
    }
}


package com.example.car.app.demo.carappdemo.controller;

import com.example.car.app.demo.carappdemo.exception.CarNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CarControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler({CarNotFoundException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String carNotFoundExceptionHandler(CarNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String validationExceptionHandler(MethodArgumentNotValidException exception) {
        return exception.getMessage();
    }
}

package com.example.car.app.demo.carappdemo.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(Long id) {
        super("Could not found car with specified ID : " + id);
    }
}

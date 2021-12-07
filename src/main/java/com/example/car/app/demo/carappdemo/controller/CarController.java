package com.example.car.app.demo.carappdemo.controller;

import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CarController {

    Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    CarService carService;

    @PostMapping("/cars")
    public CarResponseDTO addNewCar(@RequestBody @Valid CarRequestDTO newCar) {
        logger.info("INCOMING Add New Car REQUEST :" + newCar.toString());
        CarResponseDTO newCarAddedToSystem = carService.addNewCar(newCar);
        logger.info("OUTGOING Add New Car RESPONSE :" + newCarAddedToSystem.toString());
        return newCarAddedToSystem;
    }

    @GetMapping("/cars/{id}")
    public CarResponseDTO getCarDetails(@PathVariable Long id) {
        logger.info("INCOMING GET Car Details REQUEST :" + id);
        CarResponseDTO carResponseDTO = carService.getCarDetails(id);
        logger.info("OUTGOING GET Car Details REQUEST :" + carResponseDTO.toString());
        return carResponseDTO;
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarDetails(@PathVariable Long id) {
        logger.info("INCOMING DELETE Car Details REQUEST :" + id);
        carService.delete(id);
        logger.info("DELETED Car :" + id);
    }

}

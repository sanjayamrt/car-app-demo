package com.example.car.app.demo.carappdemo.controller;

import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.service.CarService;
import com.example.car.app.demo.carappdemo.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/cars")

    public CarResponseDTO addNewCar(@RequestBody @Valid CarRequestDTO newCar) {
        CarResponseDTO newCarAddedToSystem = carService.addNewCar(newCar);
        return newCarAddedToSystem;
    }

}

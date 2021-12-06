package com.example.car.app.demo.carappdemo.service;

import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;

public interface CarService {

    public CarResponseDTO addNewCar(CarRequestDTO newCar);

    public CarResponseDTO getCarDetails(Long id);

    public void delete(Long id);
}

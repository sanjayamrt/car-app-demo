package com.example.car.app.demo.carappdemo.service;

import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.enitity.Car;
import com.example.car.app.demo.carappdemo.mapper.CarMapper;
import com.example.car.app.demo.carappdemo.repository.CarRepository;
import org.apache.catalina.util.CharsetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    public CarResponseDTO addNewCar(CarRequestDTO newCar) {
        Car car = new Car(newCar.getMake(), newCar.getModel(),newCar.getYear());
        car = this.carRepository.save(car);
        return carMapper.carToCarResponseDTO(car);
    }
}

package com.example.car.app.demo.carappdemo.service;

import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.enitity.Car;
import com.example.car.app.demo.carappdemo.exception.CarNotFoundException;
import com.example.car.app.demo.carappdemo.mapper.CarMapper;
import com.example.car.app.demo.carappdemo.repository.CarRepository;
import org.apache.catalina.util.CharsetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    public CarResponseDTO addNewCar(CarRequestDTO newCar) {
        Car car = new Car(newCar.getMake(), newCar.getModel(), newCar.getYear(), newCar.getColor());
        car = this.carRepository.save(car);
        return carMapper.carToCarResponseDTO(car);
    }

    public CarResponseDTO getCarDetails(Long id) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        Car car = optionalCar.orElseThrow(() -> new CarNotFoundException(id));
        return carMapper.carToCarResponseDTO(car);
    }

    public void delete(Long id) {
        this.carRepository.deleteById(id);
    }
}

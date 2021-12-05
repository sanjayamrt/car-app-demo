package com.example.car.app.demo.carappdemo.repository;

import com.example.car.app.demo.carappdemo.enitity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

package com.example.car.app.demo.carappdemo.mapper;

import com.example.car.app.demo.carappdemo.dto.CarRequestDTO;
import com.example.car.app.demo.carappdemo.dto.CarResponseDTO;
import com.example.car.app.demo.carappdemo.enitity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "year", target = "madeYear")
    Car carRequestDTOToCar(CarRequestDTO requestDTO);

    @Mapping(source = "madeYear", target = "year")
    CarResponseDTO carToCarResponseDTO(Car car);
}


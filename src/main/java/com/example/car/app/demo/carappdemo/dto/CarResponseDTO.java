package com.example.car.app.demo.carappdemo.dto;

import java.util.Objects;


public class CarResponseDTO {

    private Long id;

    private String make;

    private String model;

    private Integer year;

    public CarResponseDTO(Long id, String make, String model, Integer year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponseDTO that = (CarResponseDTO) o;
        return getId().equals(that.getId()) && getMake().equals(that.getMake()) && getModel().equals(that.getModel()) && getYear().equals(that.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getYear());
    }
}

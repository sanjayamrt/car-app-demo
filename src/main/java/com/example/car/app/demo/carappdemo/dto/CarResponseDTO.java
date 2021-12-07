package com.example.car.app.demo.carappdemo.dto;

import java.util.Objects;


public class CarResponseDTO {

    private Long id;

    private String make;

    private String model;

    private Integer year;

    private String color;

    private String modelDescription;

    public CarResponseDTO(Long id, String make, String model, Integer year, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public String getModelDescription() {
        return modelDescription;
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

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "CarResponseDTO{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", modelDescription='" + modelDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponseDTO that = (CarResponseDTO) o;
        return getId().equals(that.getId()) && getMake().equals(that.getMake())
                && getModel().equals(that.getModel()) && getYear().equals(that.getYear())
                && getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(), getYear(), getColor());
    }
}

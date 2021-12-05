package com.example.car.app.demo.carappdemo.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CarRequestDTO {

    @NotNull(message = "'make' is a mandatory parameter")
    private String make;

    @NotNull(message = "'model' is a mandatory parameter")
    private String model;

    @NotNull(message = "'year' is a mandatory parameter")
    @Digits(integer = 4, fraction = 0, message = "Car make year should be a valid 4 digit number")
    private Integer year;

    protected CarRequestDTO() {
    }

    public CarRequestDTO(String make, String model, Integer year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRequestDTO that = (CarRequestDTO) o;
        return Objects.equals(getMake(), that.getMake()) && Objects.equals(getModel(), that.getModel()) && Objects.equals(getYear(), that.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getYear());
    }
}


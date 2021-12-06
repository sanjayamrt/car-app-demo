package com.example.car.app.demo.carappdemo.enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String make;

    private String model;

    private Integer madeYear;

    private String color;

    protected Car() {
    }

    public Car(String make, String model, Integer madeYear, String color) {
        this.make = make;
        this.model = model;
        this.madeYear = madeYear;
        this.color = color;
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

    public Integer getMadeYear() {
        return madeYear;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMadeYear(Integer madeYear) {
        this.madeYear = madeYear;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId()) && getMake().equals(car.getMake())
                && getModel().equals(car.getModel()) && getMadeYear().equals(car.getMadeYear())
                && getColor().equals(getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMake(), getModel(),
                getMadeYear(),getColor());
    }
}
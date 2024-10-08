package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarPutDto {

    private String name;

    @JsonProperty("car_number")
    private String carNumber;

    @Override
    public String toString() {
        return "CarPutDto{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}

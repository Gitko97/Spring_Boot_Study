package com.example.hello.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(value= PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {

    private String name;
    private int age;
    private List<CarPutDto> carList;

    @Override
    public String toString() {
        return "PutRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carPutDtoList=" + carList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarPutDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarPutDto> carList) {
        this.carList = carList;
    }
}

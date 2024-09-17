package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class User {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Valid
    private List<Car> cars;

    @Size(min = 6, max = 6)
    @YearMonth(pattern = "yyyyMM")
    private String reqYearMonth;

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                '}';
    }
}

package com.cars.application.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Car {
    private int numberOfCar;
    private String make;
    private String model;
    private String year;
    private List<String> engine;
    private List<String> transmission;
}
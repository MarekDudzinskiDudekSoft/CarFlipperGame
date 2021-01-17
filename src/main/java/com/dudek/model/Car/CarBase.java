package com.dudek.model.Car;

import java.util.List;

public class CarBase {

    private final static int initialCarsNumber = 20;
    private List<Car> carsList;

    public CarBase(CarGenerator generator) {
        carsList = generator.generateCars(initialCarsNumber);
    }

    public void printCarsToSell() {
        System.out.println(carsList);
    }

}

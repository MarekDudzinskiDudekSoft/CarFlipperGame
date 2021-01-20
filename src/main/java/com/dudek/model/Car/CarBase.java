package com.dudek.model.Car;

import java.util.List;

public class CarBase {

    private final static int initialCarsNumber = 20;
    private final List<Car> carsList;

    public CarBase(CarGenerator generator) {
        carsList = generator.generateManyCars(initialCarsNumber);
    }

    public void printCarsToSell() {
        System.out.println(carsList);
    }

    public Car getACar(int index) {
        return carsList.get(index);
    }

    public void removeACar(Car car) {
        carsList.remove(car);
    }

    public void generateNewCar(int index){
        Car newCar = new Car();
        carsList.add(index, newCar);
    }

}

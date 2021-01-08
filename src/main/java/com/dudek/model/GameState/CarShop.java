package com.dudek.model.GameState;

import com.dudek.model.Car.Car;

import java.util.List;

public class CarShop {

    private final int initialCarsNumber = 20;
    private List<Car> carsList;
    private List<Car> ownedCars;

    public CarShop(CarGenerator generator){
      //  generator.generateCars(initialCarsNumber);

    }

    public void sellACar(Car car) {
        carsList.remove(car);
        ownedCars.add(car);
    }

    public void printCarsToSell(){
        System.out.println(ownedCars);
    }

    public void printOwnedCars(){
        System.out.println(ownedCars);
    }

}

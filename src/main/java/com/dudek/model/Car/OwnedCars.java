package com.dudek.model.Car;

import java.util.ArrayList;
import java.util.List;

public class OwnedCars {

    private List<Car> ownedCarList;

    public OwnedCars() {
        this.ownedCarList = new ArrayList<>();
    }

    public void buyACar(Car car){
        ownedCarList.add(car);
    }

    public void sellACar(Car car){
        ownedCarList.remove(car);
    }

    public List<Car> getOwnedCarList() {
        return ownedCarList;
    }

    @Override
    public String toString() {
        return "Posiadane samochody: " + "\n" +
                ownedCarList +
                '}';
    }
}

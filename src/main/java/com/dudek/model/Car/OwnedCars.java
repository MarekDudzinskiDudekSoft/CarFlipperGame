package com.dudek.model.Car;

import java.util.List;

public class OwnedCars {

    private List<Car> ownedCarList;

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
        return "OwnedCars{" +
                "ownedCarList=" + ownedCarList +
                '}';
    }
}

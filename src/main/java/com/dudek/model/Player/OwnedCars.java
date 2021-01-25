package com.dudek.model.Player;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.Car;

import java.util.ArrayList;
import java.util.List;

public class OwnedCars {

    private List<Car> ownedCarList;

    public OwnedCars() {
        this.ownedCarList = new ArrayList<>();
    }

    public void buyACar(Car car) {
        ownedCarList.add(car);
    }

    public void removeACar(Car car) {
        ownedCarList.remove(car);
    }

    public Car getACar(int index) {
        return ownedCarList.get(index);
    }

    @Override
    public String toString() {
        return "Posiadane samochody: " + "\n" +
                ownedCarList;
    }

    public boolean isEmpty(){
        return ownedCarList.isEmpty();
    }

    public Car getCarFromBase() {
        System.out.println("Podaj indeks auta do sprzedania: ");
        int chosenOption = DataReader.readOptionFromRange(1,ownedCarList.size());
        return ownedCarList.get(chosenOption);
    }

}
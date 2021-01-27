package com.dudek.model.Player;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarView;

import java.util.ArrayList;
import java.util.List;

public class OwnedCars {

    private final List<Car> ownedCarList;

    public OwnedCars() {
        this.ownedCarList = new ArrayList<>();
    }

    public void buyACar(Car car) {
        ownedCarList.add(car);
    }

    public void removeACar(Car car) {
        ownedCarList.remove(car);
    }

    public void printOwnedCars() {
        for (int i = 1; i < ownedCarList.size() + 1; i++) {
            CarView carView = new CarView(i, ownedCarList.get(i - 1));
            System.out.println(carView);
        }
    }

    public List<Car> getOwnedCarList() {
        return ownedCarList;
    }

    public List<Car> getBrokenCars(){
        List<Car> brokenCars = new ArrayList<>();
        getOwnedCarList().stream().filter(e-> !e.isNotBroken()).forEach(brokenCars::add);
        return brokenCars;
    }

    public boolean isEmpty() {
        return ownedCarList.isEmpty();
    }

    public Car getCarFromBase() {
        System.out.println("Podaj indeks auta: ");
        int chosenOption = DataReader.readOptionFromRange(1, ownedCarList.size());
        return ownedCarList.get(chosenOption);
    }

    public void printRepairedParts(){
        ownedCarList.forEach(Car::printRepairedCarParts);
    }

}
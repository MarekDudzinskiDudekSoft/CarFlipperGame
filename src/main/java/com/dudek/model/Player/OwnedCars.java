package com.dudek.model.Player;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OwnedCars implements Serializable {

    private final List<Car> ownedCarList;

    public OwnedCars() {
        this.ownedCarList = new ArrayList<>();
    }

    public void addCar(Car car) {
        ownedCarList.add(car);
    }

    public void removeCar(Car car) {
        ownedCarList.remove(car);
    }

    public void printOwnedCars() {
        for (int i = 1; i < getOwnedCarList().size() + 1; i++) {
            CarView carView = new CarView(i, getOwnedCarList().get(i - 1));
            System.out.println(carView);
        }
    }

    public List<Car> getOwnedCarList() {
        return new ArrayList<>(ownedCarList);
    }

    public List<Car> getBrokenCars() {
        List<Car> brokenCars = new ArrayList<>();
        getOwnedCarList().stream().filter(e -> !e.isNotBroken()).forEach(brokenCars::add);
        return brokenCars;
    }

    public boolean isEmpty() {
        return getOwnedCarList().isEmpty();
    }

    public Car getCarFromBase() {
        System.out.println("Podaj indeks auta: ");
        int chosenOption = DataReader.readOptionFromRange(1, getOwnedCarList().size());
        return getOwnedCarList().get(chosenOption);
    }

    public void printRepairedParts() {
        getOwnedCarList().forEach(Car::printRepairedCarParts);
    }


}
package com.dudek.model.Player;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarView;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OwnedCars implements Serializable {

    private final List<Car> ownedCarList;
    private final static double TRADER_COMMISSION = 1.15;

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
        return getOwnedCarList().stream().filter(e -> !e.isNotBroken()).collect(Collectors.toList());
    }

    public boolean isOwnedCarsEmpty() {
        return getOwnedCarList().isEmpty();
    }

    public Car getBrokenCarFromBase() {
        System.out.println("Podaj indeks auta: ");
        int chosenOption = DataReader.readOptionFromRange(1, getBrokenCars().size());
        return getBrokenCars().get(chosenOption);
    }
    public Car getCarFromBase() {
        System.out.println("Podaj indeks auta: ");
        int chosenOption = DataReader.readOptionFromRange(1, getOwnedCarList().size());
        return getOwnedCarList().get(chosenOption);
    }

    public void printRepairedParts() {
        getOwnedCarList().forEach(Car::printRepairedCarParts);
    }

    public BigDecimal calculateCarPrice15PercentHigher(Car car) {
        return car.getValueWithParts().multiply(BigDecimal.valueOf(TRADER_COMMISSION));
    }

}
package com.dudek.model.Car;

import com.dudek.menu.DataReader;

import java.io.Serializable;
import java.util.List;

public class NewCarsDatabase implements Serializable {

    private final static int initialCarsNumber = 20;
    private final List<Car> carsList;

    public NewCarsDatabase(CarGenerator generator) {
        carsList = generator.generateManyCars(initialCarsNumber);
    }

    public void printCarsForSale() {
        //   System.out.println(carsList);
        //  carsList.forEach(e -> System.out.println(e.toString()));        //to umozliwia podejscie do kazdego elementu konterena osobno

        for (int i = 1; i < carsList.size() + 1; i++) {
            CarView carView = new CarView(i, carsList.get(i - 1));
            System.out.println(carView);
        }
    }

    public Car getChosenCar() {
        System.out.println("Podaj indeks auta do kupienia: ");
        int chosenOption = DataReader.readOptionFromRange(1, carsList.size());
        return carsList.get(chosenOption);
    }

    public void sellACar(Car car) {
        carsList.remove(car);
    }

    public void generateNewCar() {
        Car newCar = new Car();
        carsList.add(newCar);
    }

}

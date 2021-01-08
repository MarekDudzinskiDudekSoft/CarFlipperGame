package com.dudek.model.GameState;

import com.dudek.model.Car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    private List<Car> carList = new ArrayList<>();

    private List<Car> generateCars(int howManyCars) {
        for (int i = 0; i < howManyCars; i++) {
           // carList.add(new Car());
        }
        return carList;
    }
}

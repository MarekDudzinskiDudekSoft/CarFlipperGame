package com.dudek.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarGenerator {

    List<Car> generateCars(int howManyCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < howManyCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}

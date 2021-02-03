package com.dudek.model.Car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarGenerator implements Serializable {

    List<Car> generateManyCars(int howManyCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < howManyCars; i++) {
            carList.add(new Car());
        }
        return carList;
    }

}

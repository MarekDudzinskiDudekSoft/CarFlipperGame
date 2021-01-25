package com.dudek.model.Car;

public class CarView {

    private final long carId;
    private final Car car;

    public CarView(long carId, Car car) {
        this.carId = carId;
        this.car = car;
    }

    @Override
    public String toString() {
        return "ID:" + carId + car;
    }
}

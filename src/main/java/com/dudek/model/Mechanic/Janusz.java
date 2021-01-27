package com.dudek.model.Mechanic;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarParts.CarPart;

import java.math.BigDecimal;

public class Janusz extends Mechanic {

    protected Janusz() {
        super(100, BigDecimal.valueOf(600));
    }

    @Override
    public BigDecimal repairCarPart(Car car, CarPart carPart) {
        carPart.repair(this);
        return calculateRepairCostWithSalary(car, carPart);
    }
}

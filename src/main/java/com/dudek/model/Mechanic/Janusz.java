package com.dudek.model.Mechanic;

import com.dudek.model.Car.CarParts.CarPart;

import java.math.BigDecimal;

public class Janusz extends Mechanic {

    protected Janusz() {
        super(100, BigDecimal.valueOf(500));
    }

    @Override
    public BigDecimal repairCarPart(CarPart carPart) {
        carPart.repair(this);
        return calculateRepairCost(carPart);
    }
}

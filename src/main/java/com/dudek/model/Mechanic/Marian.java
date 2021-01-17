package com.dudek.model.Mechanic;

import com.dudek.model.Car.CarParts.CarPart;

import java.math.BigDecimal;

public class Marian extends Mechanic {

    public Marian() {
        super(90, BigDecimal.valueOf(300));
    }

    @Override
    public BigDecimal repairCarPart(CarPart carPart) {
        carPart.repair(this);

        if (!carPart.isOk()) {
            Janusz janusz = new Janusz();
            return janusz.repairCarPart(carPart).add(calculateRepairCost(carPart));
        }
        return calculateRepairCost(carPart);
    }

}


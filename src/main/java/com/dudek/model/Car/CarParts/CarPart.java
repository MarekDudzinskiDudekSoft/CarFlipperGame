package com.dudek.model.Car.CarParts;

import com.dudek.model.Mechanic.Mechanic;
import com.dudek.model.Randomiser;

import java.math.BigDecimal;
import java.util.Random;

public abstract class CarPart {

    private static Random random = new Random();
    private final BigDecimal multiplier;
    private boolean isOk;

    CarPart(BigDecimal multiplier) {
        this.isOk= Randomiser.createBooleanWithTruePropability(95);
        this.multiplier = multiplier;
    }

    public BigDecimal calculatePartValue(BigDecimal value) {
        return value.multiply(multiplier);
    }

    public boolean isOk() {
        return isOk;
    }

    public void repair(Mechanic mechanic) {
        this.isOk = true;
    }
}
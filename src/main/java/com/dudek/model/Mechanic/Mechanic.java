package com.dudek.model.Mechanic;

import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public abstract class Mechanic {

    private int successRate;
    private BigDecimal mechanicSalary;

    Mechanic(int successRate, BigDecimal mechanicSalary) {
        this.successRate = successRate;
        this.mechanicSalary = mechanicSalary;
    }

    public abstract BigDecimal repairCarPart(CarPart carPart);

    protected BigDecimal getMechanicSalary() {
        return mechanicSalary;
    }

    public boolean canRepair() {
        return Randomizer.createBooleanWithTruePropability(successRate);
    }

    protected BigDecimal calculateRepairCost(CarPart carPart){         //todo logika wyceny
    return null;// sprawdzac musi czy mamy kase na naprawe z GameState
    }


}

//uporzadkuj co jest wspolne
//
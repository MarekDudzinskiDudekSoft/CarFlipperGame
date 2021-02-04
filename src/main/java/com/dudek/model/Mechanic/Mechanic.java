package com.dudek.model.Mechanic;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Randomizer;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Mechanic implements Serializable {

    private final String name;
    private final int successRate;
    private final BigDecimal mechanicSalary;

    Mechanic(String name, int successRate, BigDecimal mechanicSalary) {
        this.name = name;
        this.successRate = successRate;
        this.mechanicSalary = mechanicSalary;
    }

    public abstract BigDecimal repairCarPart(Car car, CarPart carPart);

    protected BigDecimal getMechanicSalary() {
        return mechanicSalary;
    }

    public boolean canRepair() {
        return Randomizer.createBooleanWithTrueProbability(successRate);
    }

    public BigDecimal calculateRepairCostWithSalary(Car car, CarPart carPart) {
        return car.calculateCartPartPrice(carPart).add(getMechanicSalary());
    }

    public String getName() {
        return name;
    }
}

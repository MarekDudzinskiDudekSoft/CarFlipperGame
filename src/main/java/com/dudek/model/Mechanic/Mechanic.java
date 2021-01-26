package com.dudek.model.Mechanic;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Car.Segment;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public abstract class Mechanic {

    private int successRate;
    private BigDecimal mechanicSalary;

    Mechanic(int successRate, BigDecimal mechanicSalary) {
        this.successRate = successRate;
        this.mechanicSalary = mechanicSalary;
    }

    public abstract BigDecimal repairCarPart(Car car,CarPart carPart);

    protected BigDecimal getMechanicSalary() {
        return mechanicSalary;
    }

    public boolean canRepair() {
        return Randomizer.createBooleanWithTruePropability(successRate);
    }

    public BigDecimal calculateRepairCost(Car car, CarPart carPart) {
        BigDecimal price = new BigDecimal(0);

        if (car.getSegment().equals(Segment.PREMIUM)) {
            price = carPart.getBaseValue().multiply(BigDecimal.valueOf(2));
        }

        if (car.getSegment().equals(Segment.STANDRAD)) {
            price = carPart.getBaseValue().multiply(BigDecimal.valueOf(1.5));
        }

        if (car.getSegment().equals(Segment.BUDGET)) {
            price = carPart.getBaseValue().multiply(BigDecimal.valueOf(1.1));
        }

        return price.add(getMechanicSalary());
    }



}

package com.dudek.model.Mechanic;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarEnums.Segment;
import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public abstract class Mechanic {

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
        return calculateRepairCost(car,carPart).add(getMechanicSalary());
    }

    private BigDecimal calculateRepairCost(Car car, CarPart carPart) {
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

        return price;
    }

    public String getName() {
        return name;
    }
}

package com.dudek.model.Mechanic;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public class Adrian extends Mechanic implements CanBreakAPart {

    private final static int criticalErrorChance = 2;
    private final static String name = "Adrian";

    protected Adrian() {
        super(name, 60, BigDecimal.valueOf(200));
    }

    @Override
    public BigDecimal repairCarPart(Car car, CarPart carPart) {
        carPart.repair(this);
        carPart.breakAPart(this);

        if (!carPart.isOk()) {
            Janusz janusz = new Janusz();
            return janusz.calculateRepairCostWithSalary(car, carPart).add(getMechanicSalary());
        }
        return calculateRepairCostWithSalary(car, carPart);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean didPartBroke() {
        return Randomizer.createBooleanWithTrueProbability(criticalErrorChance);
    }
}


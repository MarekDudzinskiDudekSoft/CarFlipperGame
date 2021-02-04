package com.dudek.model.Mechanic;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public class Adrian extends Mechanic implements CanBreakAPart {

    private final static int CRITICAL_ERROR_CHANCE = 3;
    private final static String name = "Adrian";

    protected Adrian() {
        super(name, 60, BigDecimal.valueOf(200));
    }

    @Override
    public BigDecimal repairCarPart(Car car, CarPart carPart) {
        carPart.repair(this);
        carPart.breakAPart(this);

        if (!carPart.isOk()) {
            System.err.println("Adrian nie umie naprawic auta, musial wezwac Janusza, bedzie to dodatkowo kosztowac!");
            Janusz janusz = new Janusz();
            return janusz.repairCarPart(car, carPart);

        }
        return calculateRepairCostWithSalary(car, carPart);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean didPartBroke() {
        return Randomizer.createBooleanWithTrueProbability(CRITICAL_ERROR_CHANCE);
    }
}


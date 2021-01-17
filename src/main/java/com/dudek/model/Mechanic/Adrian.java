package com.dudek.model.Mechanic;

import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public class Adrian extends Mechanic implements CanBreakAPart {

    private final static int criticalErrorChance = 2;

    public Adrian() {
        super(80, BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal repairCarPart(CarPart carPart) {
        carPart.repair(this);
        carPart.breakAPart(this);

        if (!carPart.isOk()) {
            Janusz janusz = new Janusz();
            return janusz.repairCarPart(carPart).add(calculateRepairCost(carPart));
        }
        return calculateRepairCost(carPart);
    }

    @Override
    public boolean didPartBroke() {
        return Randomizer.createBooleanWithTruePropability(criticalErrorChance);
    }
}


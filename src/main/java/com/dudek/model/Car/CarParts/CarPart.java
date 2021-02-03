package com.dudek.model.Car.CarParts;

import com.dudek.model.Mechanic.CanBreakAPart;
import com.dudek.model.Mechanic.Mechanic;
import com.dudek.model.Randomizer;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class CarPart implements Serializable {

    private final BigDecimal multiplier;
    private boolean isOk;
    private final String name;
    private final BigDecimal baseValue;

    CarPart(BigDecimal multiplier, String name, BigDecimal baseValue ) {
        this.name = name;
        this.isOk = Randomizer.createBooleanWithTrueProbability(70);
        this.multiplier = multiplier;
        this.baseValue = baseValue;
    }

    public BigDecimal calculatePartValue(BigDecimal value) {
        return value.multiply(multiplier);
    }

    public boolean isOk() {
        return isOk;
    }

    public void repair(Mechanic mechanic) {
        if (mechanic.canRepair()) {
            this.isOk = true;
        }
    }

    public BigDecimal getBaseValue() {
        return baseValue;
    }

    public void breakAPart(CanBreakAPart mechanic) {
        if (mechanic.didPartBroke()) {
            this.isOk = false;
            System.err.println("Mechanik uszkodzil część: ");
        }
    }

    private String isOkconverterToString(boolean isOk) {
        if (this.isOk)
            return "Sprawny";
        else
            return "Do naprawy";
    }

    public String getName() {
        return name;
    }

    public String getIsOkInString(){
        return isOkconverterToString(this.isOk);
    }


    @Override
    public String toString() {
        return getName() + ": "+ getIsOkInString();
    }
}
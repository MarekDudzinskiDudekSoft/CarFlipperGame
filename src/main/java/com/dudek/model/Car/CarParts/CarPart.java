package com.dudek.model.Car.CarParts;

import com.dudek.model.Mechanic.CanBreakAPart;
import com.dudek.model.Mechanic.Mechanic;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public abstract class CarPart {

    private final BigDecimal multiplier;
    private boolean isOk;

    CarPart(BigDecimal multiplier) {
        this.isOk = Randomizer.createBooleanWithTruePropability(95);
        this.multiplier = multiplier;
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

    public void breakAPart(CanBreakAPart mechanic) {
        if (mechanic.didPartBroke()) {
            this.isOk = false;
        }
    }

    private String isOKconverterTOString(boolean isOk) {
        if (this.isOk)
            return "Sprawny";
        else
            return "Do naprawy";
    }

    @Override
    public String toString() {
        return isOKconverterTOString(this.isOk);
    }
}
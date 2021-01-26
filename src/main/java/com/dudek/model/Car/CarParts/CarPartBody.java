package com.dudek.model.Car.CarParts;

import java.math.BigDecimal;

public final class CarPartBody extends CarPart {
    public CarPartBody() {
        super(BigDecimal.valueOf(0.5), "Karoseria", BigDecimal.valueOf(1000));
    }
}

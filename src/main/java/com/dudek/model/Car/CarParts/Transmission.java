package com.dudek.model.Car.CarParts;

import java.math.BigDecimal;

public final class Transmission extends CarPart {
    public Transmission() {
        super( BigDecimal.valueOf(0.5), "Skrznia biegów", BigDecimal.valueOf(1000));
    }
}

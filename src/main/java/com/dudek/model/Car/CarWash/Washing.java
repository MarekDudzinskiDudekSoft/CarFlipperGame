package com.dudek.model.Car.CarWash;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

final public class Washing {


    private BigDecimal price;
    private boolean isDone;

    public Washing() {
        this.price = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(WashingPrices.MIN_PRICE_OF_WASH, WashingPrices.MAX_PRICE_OF_WASH));
        this.isDone = false;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void wash() {
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }

    private String isDoneConverterToString() {
        if (this.isDone)
            return "Tak";
        else
            return "Nie";
    }

    @Override
    public String toString() {
        return isDoneConverterToString();

    }
}

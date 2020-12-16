package com.dudek.model.Car;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

final public class Washing {
    private BigDecimal price;
    private boolean isDone;

     Washing() {
        this.price = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(WashingPrices.MIN_PRICE_OF_WASH, WashingPrices.MAX_PRICE_OF_WASH));
        this.isDone = false;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void wash() {
        isDone = true;
    }

     boolean isDone() {
        return isDone;
    }
}

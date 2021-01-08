package com.dudek.model.GameState;

import com.dudek.model.Car.Brand;
import com.dudek.model.Randomiser;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Client {
    private BigDecimal cash;
    private Brand wantedBrand;          //TODO zamienić na tablice/liste/dwa oddzielne pola?
    private boolean isInterestedInBrokenCars;
    private boolean isInterestedInDeliveryCars;

    Client() {
        this.cash = createClientCash();
        this.wantedBrand = Brand.randomBrand();
        isInterestedInBrokenCars = Randomiser.createBooleanWithTruePropability(90);
        isInterestedInDeliveryCars = Randomiser.createBooleanWithTruePropability(5);
    }

    private BigDecimal createClientCash(){
        return BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(15000, 25000));
    }

    public Brand getWantedBrand() {
        return wantedBrand;
    }

    public boolean isInterestedInBrokenCars() {
        return isInterestedInBrokenCars;
    }

    public boolean isInterestedInDeliveryCars() {
        return isInterestedInDeliveryCars;
    }

    public BigDecimal getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "Fundusze: " + getCash() + ", Zainteresowany marką: " + getWantedBrand() +
                ", Zainteresowany uszkodzonymi autami: " + isInterestedInBrokenCars() +
                ", Zainteresowany autami dostawczymi: " + isInterestedInDeliveryCars() + " \n";
    }
}


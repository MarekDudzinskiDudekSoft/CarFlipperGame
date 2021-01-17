package com.dudek.model.Client;

import com.dudek.model.Car.Brand;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;


public class Client {
    private BigDecimal cash;
    private Brand wantedBrand;          //TODO zamienić na tablice/liste/dwa oddzielne pola?
    private boolean isInterestedInBrokenCars;
    private boolean isInterestedInDeliveryCars;

    Client() {
        this.cash = Randomizer.createRandomDecimalFromRange(15000,25000);
        this.wantedBrand = Brand.RandomBrand.randomBrand();
        isInterestedInBrokenCars = Randomizer.createBooleanWithTruePropability(20);
        isInterestedInDeliveryCars = Randomizer.createBooleanWithTruePropability(5);
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


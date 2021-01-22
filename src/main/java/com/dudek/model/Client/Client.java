package com.dudek.model.Client;

import com.dudek.model.Car.Brand;
import com.dudek.model.Car.Car;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;


public class Client {
    private BigDecimal cash;                                    //TODO Add random name from database
    private final Brand wantedBrand;
    private final boolean isInterestedInBrokenCars;
    private final boolean isInterestedInDeliveryCars;

    public Client() {
        this.cash = Randomizer.createRandomDecimalFromRange(350, 500).multiply(BigDecimal.valueOf(100));
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
                ", Zainteresowany uszkodzonymi autami: " + convertBooleanToString(isInterestedInBrokenCars()) +
                ", Zainteresowany autami dostawczymi: " + convertBooleanToString(isInterestedInDeliveryCars()) + " \n";
    }

    public boolean canBuyCar(Car car) {
        if (this.cash.compareTo(car.getValue()) >= 0) {
            return true;
        } else {
            System.out.println("Niewystarczajace środki na zakup auta! ");
            return false;
        }
    }

    private String convertBooleanToString(boolean bool) {
        if (bool)
            return "Tak";
        else
            return "Nie";
    }
}


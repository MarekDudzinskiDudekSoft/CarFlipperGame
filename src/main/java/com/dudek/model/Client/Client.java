package com.dudek.model.Client;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarEnums.Brand;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Client {
    private final BigDecimal cash;                                    //TODO Add random name from database
    private final List<Brand> wantedBrand = new ArrayList<>(2);
    private final boolean isInterestedInBrokenCars;
    private final boolean isInterestedInDeliveryCars;

    public Client() {
        this.cash = Randomizer.createRandomDecimalFromRange(450, 600).multiply(BigDecimal.valueOf(100));
        this.wantedBrand.add(Brand.RandomBrand.randomBrand());
        this.wantedBrand.add(Brand.RandomBrand.randomBrand());
        isInterestedInBrokenCars = Randomizer.createBooleanWithTrueProbability(10);
        isInterestedInDeliveryCars = Randomizer.createBooleanWithTrueProbability(5);
    }

    public List<Brand> getWantedBrand() {
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
        return " Fundusze: " + getCash() + ", Zainteresowany marką: " + getWantedBrand() +
                ", Zainteresowany uszkodzonymi autami: " + convertBooleanToString(isInterestedInBrokenCars()) +
                ", Zainteresowany autami dostawczymi: " + convertBooleanToString(isInterestedInDeliveryCars());
    }

    public boolean canBuyCar(Car car) {
        if (this.cash.compareTo(car.getValueWithParts()) >= 0) {
            return true;
        } else {
            System.err.println("Niewystarczajace środki na zakup auta! ");
            return false;
        }
    }

    private String convertBooleanToString(boolean bool) {
        if (bool)
            return "Tak";
        else
            return "Nie";
    }

    public boolean isInterestedInThisCar(Car car) {
        if (this.wantedBrand.contains(car.getBrand())) {
            return validateClientInterest(car);
        }
        System.err.println("Klient nie jest zainteresowany tą marką auta!");
        return false;
    }

    private boolean validateClientInterest(Car car) {
        if (car.isNotBroken()) {
            return true;
        }

        if (!car.isNotBroken() && this.isInterestedInBrokenCars) {
            return true;
        }

        System.err.println("Klient nie jest zainteresowany uszkodzonymi autami!");
        return false;
    }
}

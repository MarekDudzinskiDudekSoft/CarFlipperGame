package com.dudek.model.Client;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarEnums.Brand;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Client {

    private final BigDecimal cash;
    ClientNameRandomizer clientNameRandomizer = new ClientNameRandomizer();
    private final String firstName = clientNameRandomizer.randomizeFirstName();
    private final String lastName = clientNameRandomizer.randomizeLastName();
    private final Set<Brand> wantedBrands = new HashSet<>(2);
    private final boolean isInterestedInBrokenCars;
    private final boolean isInterestedInDeliveryCars;


    private Client(BigDecimal cash, boolean isInterestedInBrokenCars, boolean isInterestedInDeliveryCars) {
        this.cash = cash;
        this.isInterestedInBrokenCars = isInterestedInBrokenCars;
        this.isInterestedInDeliveryCars = isInterestedInDeliveryCars;
    }

    public Set<Brand> getWantedBrands() {
        return new HashSet<>(wantedBrands);
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return " Imie: " + firstName + " Nazwisko: " + lastName + " Fundusze: " + getCash() + ", Zainteresowany marką: " + getWantedBrands() +
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
        if (this.wantedBrands.contains(car.getBrand())) {
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

    public static class ClientRandomizer {


        public static final int INTERESTED_IN_BROKEN_CARS_PROBABILITY = 10;
        public static final int INTERESTED_IN_DELIVERY_CARS_PROBABILITY = 5;

        public Client getNewRandomClient() {
            Client client = new Client(
                    Randomizer.createRandomDecimalFromRange(450, 600).multiply(BigDecimal.valueOf(100)),
                    Randomizer.createBooleanWithTrueProbability(INTERESTED_IN_BROKEN_CARS_PROBABILITY),
                    Randomizer.createBooleanWithTrueProbability(INTERESTED_IN_DELIVERY_CARS_PROBABILITY)
            );

            client.wantedBrands.add(Brand.RandomBrand.randomBrand());
            client.wantedBrands.add(Brand.RandomBrand.randomBrand());
            return client;
        }
    }


}

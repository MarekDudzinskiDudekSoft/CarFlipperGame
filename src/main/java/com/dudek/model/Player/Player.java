package com.dudek.model.Player;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;

import java.math.BigDecimal;

public class Player {

    private final static BigDecimal initialCash = new BigDecimal(300000);
    private final OwnedCars ownedCars;
    private BigDecimal cash;


    public Player() {
        this.cash = initialCash;
        this.ownedCars = new OwnedCars();
    }

    public BigDecimal getCash() {
        return cash;
    }

    public  BigDecimal getInitialCash() {
        return initialCash;
    }

    public OwnedCars getOwnedCars() {
        if (ownedCars.isEmpty())
            System.err.println("Nie posiadasz zadnych samochodów!");
        return ownedCars;
    }

    public void buyACar(Car car) {
        cash = cash.subtract(car.getValueWithParts()).subtract(payFee(car));
        ownedCars.buyACar(car);
        System.out.println("Zakupiono samochod: " + car.getBrand() + " " + car.getColor().getDescription() +
                " za " + car.getValueWithParts() + " Zaplacono podatek w wysokosci: " + payFee(car));
    }

    public void sellACar(Car car) {
        cash = cash.add(car.getValueWithParts()).subtract(payFee(car));
        ownedCars.removeACar(car);

        System.out.println("Sprzedano samochod: " + car.getBrand() + " " + car.getColor().getDescription() +
                " za " + car.getValueWithParts() + " Zaplacono podatek w wysokosci: " + payFee(car));

    }

    public void printOwnedCars() {
        if (ownedCars.isEmpty())
            System.err.println("Nie posiadasz zadnych samochodów!");
        ownedCars.printOwnedCars();
    }

    public boolean canAffordACar(Car car) {
        return (this.getCash().compareTo(car.getValueWithParts().add(payFee(car))) >= 0);
    }

    public void payForRepair(BigDecimal price) {
        this.cash = getCash().subtract(price);
    }

    public void payForCommercial(BigDecimal price) {
        this.cash = getCash().subtract(price);
    }

    private BigDecimal payFee(Car car) {
        CarFee carFee = new CarFee();
        return carFee.calculateCarFee(car);
    }
}

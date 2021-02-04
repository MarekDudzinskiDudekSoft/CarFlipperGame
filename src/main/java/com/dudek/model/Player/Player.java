package com.dudek.model.Player;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;
import com.dudek.model.Client.Client;
import com.dudek.model.Commercial.Commercial;

import java.io.Serializable;
import java.math.BigDecimal;

public class Player implements Serializable {

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

    public BigDecimal getInitialCash() {
        return initialCash;
    }

    public OwnedCars getOwnedCars() {
        if (ownedCars.isOwnedCarsEmpty())
            System.err.println("Nie posiadasz zadnych samochodów!");
        return ownedCars;
    }

    public void buyACar(Car car) {
        if (this.canAfford(car.getValueWithParts())) {
            cash = payForCarWithFee(car);
            ownedCars.addCar(car);
            System.out.println("Zakupiono samochod: " + car.getBrand() + " " + car.getColor().getDescription() +
                    " za " + car.getValueWithParts() + " Zaplacono podatek w wysokosci: " + payFee(car));
        } else {
            System.err.println("Niewystarczajaca liczba środków aby kupić to auto!");
        }
    }

    public void sellACar(Car car, Client client) {
        client.payForCar(car);
        cash = receiveCashAndPayFee(car);
        ownedCars.removeCar(car);

        System.out.println("Sprzedano samochod: " + car.getBrand() + " " + car.getColor().getDescription() +
                " za " + car.getValueWithParts() + " Zaplacono podatek w wysokosci: " + payFee(car));

    }

    public void printOwnedCars() {
        if (ownedCars.isOwnedCarsEmpty())
            System.err.println("Nie posiadasz zadnych samochodów!");
        ownedCars.printOwnedCars();
    }

    public boolean canAfford(BigDecimal price) {
        return (this.getCash().compareTo(price) >= 0);
    }

    public void payForCommercial(Commercial commercial) {
        this.cash = getCash().subtract(commercial.getPrice());
    }

    private BigDecimal payFee(Car car) {
        CarFee carFee = new CarFee();
        return carFee.calculateCarFee(car);
    }

    private BigDecimal payForCarWithFee(Car car) {
        return cash.subtract(car.getValueWithParts()).subtract(payFee(car));
    }

    private BigDecimal receiveCashAndPayFee(Car car) {
        return cash.add(ownedCars.calculateCarPrice15PercentHigher(car)).subtract(payFee(car));
    }

    public void payForRepair(BigDecimal price) {            //czy tak moze byc?
        this.cash = cash.subtract(price);
    }
}

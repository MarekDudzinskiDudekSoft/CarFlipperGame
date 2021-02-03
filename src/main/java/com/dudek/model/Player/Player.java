package com.dudek.model.Player;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;
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

    public  BigDecimal getInitialCash() {
        return initialCash;
    }

    public OwnedCars getOwnedCars() {
        if (ownedCars.isEmpty())
            System.err.println("Nie posiadasz zadnych samochodów!");
        return ownedCars;
    }

    public void buyACar(Car car) {
        cash = payForCarWithFee(car);
        ownedCars.addCar(car);
        System.out.println("Zakupiono samochod: " + car.getBrand() + " " + car.getColor().getDescription() +
                " za " + car.getValueWithParts() + " Zaplacono podatek w wysokosci: " + payFee(car));
    }

    public void sellACar(Car car) {
        cash = receiveCashAndPayFee(car);
        ownedCars.removeCar(car);

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

    public void payForCommercial(Commercial commercial) {
        this.cash = getCash().subtract(commercial.getPrice());
    }

    private BigDecimal payFee(Car car) {
        CarFee carFee = new CarFee();
        return carFee.calculateCarFee(car);
    }

    private BigDecimal payForCarWithFee(Car car){
        return cash.subtract(car.getValueWithParts()).subtract(payFee(car));
    }

    private BigDecimal receiveCashAndPayFee(Car car){
        return cash.add(car.calculateCarPrice15PercentHigher()).subtract(payFee(car));
    }

}

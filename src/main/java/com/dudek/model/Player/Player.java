package com.dudek.model.Player;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private final static BigDecimal initialCash = new BigDecimal(100000);
    private BigDecimal cash;
    private final OwnedCars ownedCars;

    public Player() {
        this.cash = initialCash;
        this.ownedCars = new OwnedCars();
    }

    private String typePlayerName() {
        return readString();
    }

    private String readString() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            System.err.println("Niepoprawny format danych");
        } catch (NullPointerException e) {
            System.err.println("Nie wprowadzono danych");
        }
        scanner.close();
        return readString();
    }

    public BigDecimal getCash() {
        return cash;
    }

    public OwnedCars getOwnedCars() {
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

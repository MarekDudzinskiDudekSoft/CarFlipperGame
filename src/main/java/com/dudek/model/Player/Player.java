package com.dudek.model.Player;

import com.dudek.model.Car.Car;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private final static BigDecimal initialCash = new BigDecimal(100000);
    private final String nickname;
    private BigDecimal cash;
    private final OwnedCars ownedCars;

    public Player() {
        this.nickname = typePlayerName();
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

    public String getNickname() {
        return nickname;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public OwnedCars getOwnedCars() {
        return ownedCars;
    }

    public void buyACar(Car car) {
        cash = cash.subtract(car.getValue());
        ownedCars.buyACar(car);
    }

    public void printOwnedCars() {
        System.out.println(ownedCars);
    }

}

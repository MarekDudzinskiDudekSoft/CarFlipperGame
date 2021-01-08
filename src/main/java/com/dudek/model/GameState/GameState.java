package com.dudek.model.GameState;

import com.dudek.model.Car.Car;
import com.dudek.model.Mechanic.Mechanic;

import java.math.BigDecimal;
import java.util.List;

public class GameState {

    private BigDecimal cash;
    private BigDecimal initialCash;
    private List<Car> carsList;
    private List<Car> shopOfCars;
    private ClientBase clients;               //TODO oddzielne klasy na kontenery
    private List<Transaction> transactions;
    private List<Mechanic> mechanics;
    private int moveCounter;

    public GameState(BigDecimal cash, BigDecimal initialCash, List<Car> carsList, List<Car> shopOfCars, List<Transaction> transactions, List<Mechanic> mechanics, int moveCounter) {
        this.cash = cash;
        this.initialCash = initialCash;
        this.carsList = carsList;
        this.shopOfCars = shopOfCars;
        this.transactions = transactions;
        this.mechanics = mechanics;
        this.moveCounter = moveCounter;

        this.clients = new ClientBase(new ClientGenerator());
    }

    public BigDecimal getCash() {
        return cash;
    }

    public BigDecimal getInitialCash() {
        return initialCash;
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public List<Car> getShopOfCars() {
        return shopOfCars;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public ClientBase getClients() {
        return clients;
    }
}

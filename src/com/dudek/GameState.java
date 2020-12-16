package com.dudek;

import com.dudek.model.Car.Car;
import com.dudek.model.Client;
import com.dudek.model.Mechanic.Mechanic;
import com.dudek.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class GameState {

    private BigDecimal cash;
    private BigDecimal initialCash;
    private List<Car> carsList;         //mapa?
    private List<Car> shopOfCars;       //mapa?
    private List<Client> clients;               //TODO oddzielne klasy na kontenery
    private List<Transaction> transactions;
    private List<Mechanic> mechanics;
    private int moveCounter;

    public GameState(BigDecimal cash, BigDecimal initialCash, List<Car> carsList, List<Car> shopOfCars, List<Client> clients, List<Transaction> transactions, List<Mechanic> mechanics, int moveCounter) {
        this.cash = cash;
        this.initialCash = initialCash;
        this.carsList = carsList;
        this.shopOfCars = shopOfCars;
        this.clients = clients;
        this.transactions = transactions;
        this.mechanics = mechanics;
        this.moveCounter = moveCounter;
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

    public List<Client> getClients() {
        return clients;
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

}

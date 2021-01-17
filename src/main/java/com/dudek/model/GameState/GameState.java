package com.dudek.model.GameState;
import com.dudek.model.Car.CarBase;
import com.dudek.model.Car.CarGenerator;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Mechanic.Mechanic;

import java.math.BigDecimal;
import java.util.List;

public class GameState {

    private BigDecimal cash;
    private BigDecimal initialCash;
    private CarBase ownedCars;              //todo to do oddzielnej klasy, nie moze byc carbase

    private CarBase carBase;
    private ClientBase clients;
    private List<Transaction> transactions;
    private List<Mechanic> mechanics;
    private int moveCounter;

    public GameState(BigDecimal cash, BigDecimal initialCash, List<Transaction> transactions, List<Mechanic> mechanics, int moveCounter) {
        this.cash = cash;
        this.initialCash = initialCash;
        this.transactions = transactions;
        this.mechanics = mechanics;
        this.moveCounter = moveCounter;

        this.ownedCars = null;
        this.clients = new ClientBase(new ClientGenerator());
        this.carBase = new CarBase(new CarGenerator());
    }

    public BigDecimal getCash() {
        return cash;
    }

    public BigDecimal getInitialCash() {
        return initialCash;
    }

    public CarBase getCarBase() {
        return carBase;
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

    public CarBase getOwnedCars() {
        return ownedCars;
    }
}

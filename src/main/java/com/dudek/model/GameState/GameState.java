package com.dudek.model.GameState;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarBase;
import com.dudek.model.Car.CarGenerator;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Mechanic.MechanicGarage;
import com.dudek.model.Player.Player;

import java.util.List;

public class GameState {

    private final Player player;
    private final CarBase carBase;
    private final ClientBase clients;
    private List<Transaction> transactions;
    private final MechanicGarage mechanicGarage;
    private int moveCounter;

    public GameState(List<Transaction> transactions) {

        this.transactions = transactions;
        this.moveCounter = 0;

        this.player = new Player();
        this.mechanicGarage = new MechanicGarage();
        this.clients = new ClientBase(new ClientGenerator());
        this.carBase = new CarBase(new CarGenerator());
    }

    public CarBase getCarBase() {
        return carBase;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public ClientBase getClients() {
        return clients;
    }

    public Player getPlayer() {
        return player;
    }

    public MechanicGarage getMechanicGarage() {
        return mechanicGarage;
    }

    public void buyACar(int index) {
        Car boughtCar = carBase.getACar(index + 1);
        if (player.getCash().compareTo(boughtCar.getValue()) >= 0) {
            transferCarFromBaseToPlayer(index, boughtCar);
        } else {
            System.err.println("Niewystarczajaca liczba środków aby kupić to auto!");
        }
    }

    private void transferCarFromBaseToPlayer(int index, Car boughtCar) {
        player.buyACar(boughtCar);
        carBase.removeACar(boughtCar);
        carBase.generateNewCar(index + 1);
    }

    public void sellACar(int index) {
        Car potentialCar = player.getOwnedCars().getACar(index);


    }


}

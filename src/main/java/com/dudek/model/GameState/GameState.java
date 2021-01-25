package com.dudek.model.GameState;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarGenerator;
import com.dudek.model.Car.NewCarsDatabase;
import com.dudek.model.Client.Client;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Mechanic.MechanicGarage;
import com.dudek.model.Player.Player;

import java.util.List;

public class GameState {

    private final Player player;
    private final NewCarsDatabase newCarsDatabase;
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
        this.newCarsDatabase = new NewCarsDatabase(new CarGenerator());
    }

    public NewCarsDatabase getCarBase() {
        return newCarsDatabase;
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

    public void buyACar() {
        int chosenOption = DataReader.readOptionFromRange(1, newCarsDatabase.getSize());
        Car boughtCar = newCarsDatabase.getACar(chosenOption);
        if (player.canAffordACar(boughtCar)) {
            transferCarAfterBuy(chosenOption, boughtCar);
        } else {
            System.err.println("Niewystarczajaca liczba środków aby kupić to auto!");
        }
    }

    private void transferCarAfterBuy(int index, Car boughtCar) {
        player.buyACar(boughtCar);
        newCarsDatabase.sellACar(boughtCar);
        newCarsDatabase.generateNewCar(index);
    }

    public void sellACar() {
        int chosenOption = DataReader.readOptionFromRange(1, player.getOwnedCars().getSize());
        Car potentialCar = player.getOwnedCars().getACar(chosenOption);
        Client potentialClient = clients.getClientFromBase();

        if (potentialClient.canBuyCar(potentialCar)) {
            transferCarAfterSell(potentialCar);
        } else {
            System.err.println("Klient nie dysponuje wystarczajacymi srodkami");
        }
    }

    private void transferCarAfterSell(Car potentialCar) {
        player.sellACar(potentialCar);
        clients.addClientToBase();
        clients.addClientToBase();
    }


}

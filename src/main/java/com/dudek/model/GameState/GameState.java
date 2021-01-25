package com.dudek.model.GameState;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarGenerator;
import com.dudek.model.Car.NewCarsDatabase;
import com.dudek.model.Client.Client;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Mechanic.Mechanic;
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

        Car boughtCar = newCarsDatabase.getACar();
        if (player.canAffordACar(boughtCar)) {
            transferCarAfterBuy(boughtCar);
            System.out.println("Zakupiono samochod: " + boughtCar.getBrand() + " " + boughtCar.getColor().getDescription() + " za " + boughtCar.getValueWithParts());
        } else {
            System.err.println("Niewystarczajaca liczba środków aby kupić to auto!");
        }
    }

    private void transferCarAfterBuy(Car boughtCar) {
        player.buyACar(boughtCar);
        newCarsDatabase.sellACar(boughtCar);
        newCarsDatabase.generateNewCar();
    }

    public void sellACar() {
        Car potentialCar = player.getOwnedCars().getCarFromBase();
        Client potentialClient = clients.getClientFromBase();

        if (potentialClient.canBuyCar(potentialCar) && potentialClient.isInterestedInThisCar(potentialCar)) {
            transferCarAfterSell(potentialCar);
            System.out.println("Sprzedano samochod: " + potentialCar.getBrand() + " " + potentialCar.getColor().getDescription() + " za " + potentialCar.getValueWithParts());
        }
    }

    private void transferCarAfterSell(Car potentialCar) {
        player.sellACar(potentialCar);
        clients.addClientToBase();
        clients.addClientToBase();
    }

    public void repairCar(Car car) {
        int chosenOption = DataReader.readOptionFromRange(1, mechanicGarage.getSize());
        Mechanic chosenMechanic = mechanicGarage.chooseMechanic(chosenOption);


    }


}

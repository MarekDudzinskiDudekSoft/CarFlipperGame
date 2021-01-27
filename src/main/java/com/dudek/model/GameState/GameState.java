package com.dudek.model.GameState;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarGenerator;
import com.dudek.model.Car.CarParts.CarPart;
import com.dudek.model.Car.NewCarsDatabase;
import com.dudek.model.Client.Client;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Commercial.Commercial;
import com.dudek.model.Commercial.CommercialFactory;
import com.dudek.model.Mechanic.Mechanic;
import com.dudek.model.Mechanic.MechanicGarage;
import com.dudek.model.Player.Player;
import com.dudek.model.Transaction.TransactionContainer;


public class GameState {

    private final Player player;
    private final NewCarsDatabase newCarsDatabase;
    private final ClientBase clients;
    private final TransactionContainer transactions;
    private final MechanicGarage mechanicGarage;
    private int moveCounter;
    private final CommercialFactory commercialFactory;

    public GameState() {
        this.moveCounter = 0;

        this.transactions = new TransactionContainer();
        this.player = new Player();
        this.mechanicGarage = new MechanicGarage();
        this.clients = new ClientBase(new ClientGenerator());
        this.newCarsDatabase = new NewCarsDatabase(new CarGenerator());
        this.commercialFactory = new CommercialFactory();
    }

    public TransactionContainer getTransactions() {
        return transactions;
    }

    public NewCarsDatabase getCarBase() {
        return newCarsDatabase;
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

    public void buyACar() {
        Car boughtCar = newCarsDatabase.getACar();
        if (player.canAffordACar(boughtCar)) {
            transferCarAfterBuy(boughtCar);
            transactions.addBuyCarTransaction();
            moveCounter++;
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
            transactions.addSellCarTransaction();
            moveCounter++;
        }
    }

    private void transferCarAfterSell(Car potentialCar) {
        player.sellACar(potentialCar);
        clients.addClientToBase();
        clients.addClientToBase();
    }

    public void repairCar() {
        Car brokenCar = player.getOwnedCars().getCarFromBase();
        CarPart brokenPart = brokenCar.choosePartToRepair();
        Mechanic chosenMechanic = mechanicGarage.chooseMechanic();

        if (player.getCash().compareTo(chosenMechanic.calculateRepairCostWithSalary(brokenCar, brokenPart)) >= 0) {
            player.payForRepair(chosenMechanic.repairCarPart(brokenCar, brokenPart));
            brokenCar.addRepairedPartToList(brokenPart);
        } else {
            System.err.println("Niewystarczające środki na naprawę!");
        }
        transactions.addCarRepairTransaction();
        moveCounter++;
        System.out.println("Naprawa przeszla pomyślnie");
    }

    public void buyCommercial() {
        Commercial commercial = commercialFactory.chooseCommercial();
        player.payForCommercial(commercial.getPrice());
        transactions.addBuyCommercialTransaction();
        moveCounter++;
        for (int i = 0; i < commercial.getClientsInterested(); i++) {
            clients.addClientToBase();
        }
    }

    public void calculateTotalRepairAndWashingCost() {
        player.getOwnedCars().getOwnedCarList().forEach(Car::printRepairAndWashCost);
    }
}

package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

import java.util.HashMap;
import java.util.Map;

public class AllOptions {

    Map<Integer, LoopOption> options = new HashMap<>();

    public AllOptions() {                               //https://devcave.pl/effective-java/wzorzec-projektowy-singleton  tutaj robimy to w ten sposob?

        ShowCarsForSale showCarsForSale = new ShowCarsForSale();
        BuyACar buyACar = new BuyACar();
        ShowOwnedCars showOwnedCars = new ShowOwnedCars();
        RepairACar repairACar = new RepairACar();
        ShowPotentialClients showPotentialClients = new ShowPotentialClients();
        SellCar sellCar = new SellCar();
        BuyACommercial buyACommercial = new BuyACommercial();
        ShowAccountBalance showAccountBalance = new ShowAccountBalance();
        ShowTransactionsHistory showTransactionsHistory = new ShowTransactionsHistory();
        ShowRepairHistoryForAllCars showRepairHistoryForAllCars = new ShowRepairHistoryForAllCars();
        ShowRepairAndWashCost showRepairAndWashCost = new ShowRepairAndWashCost();

        options.put(showCarsForSale.getNumber(), showCarsForSale);
        options.put(buyACar.getNumber(), buyACar);
        options.put(showOwnedCars.getNumber(), showOwnedCars);
        options.put(repairACar.getNumber(), repairACar);
        options.put(showPotentialClients.getNumber(), showPotentialClients);
        options.put(sellCar.getNumber(), sellCar);
        options.put(buyACommercial.getNumber(), buyACommercial);
        options.put(showAccountBalance.getNumber(), showAccountBalance);
        options.put(showTransactionsHistory.getNumber(), showTransactionsHistory);
        options.put(showRepairHistoryForAllCars.getNumber(), showRepairHistoryForAllCars);
        options.put(showRepairAndWashCost.getNumber(), showRepairAndWashCost);
    }

    public void printOptions() {
        options.forEach((key, value) -> System.out.println(value.getNumber() + " - " + value.getText()));
    }

    public void executeOption(int optionNumber, GameState state) {
        if (options.containsKey(optionNumber)) {
            options.get(optionNumber).execute(state);
        }
    }

    public int getSize(){
        return options.size();
    }
}


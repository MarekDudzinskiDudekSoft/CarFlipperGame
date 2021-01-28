package com.dudek.model.Transaction;

import com.dudek.model.Car.Car;
import com.dudek.model.Client.Client;
import com.dudek.model.Commercial.Commercial;
import com.dudek.model.Mechanic.Mechanic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionContainer {

    private final List<Transaction> transactionList = new ArrayList<>();


    public void addBuyCarTransaction(BigDecimal cash, Car car, Client client, Mechanic mechanic, Commercial commercial) {
        transactionList.add(new Transaction(TransactionType.CAR_PURCHASE, cash, car, client, mechanic, commercial));
    }

    public void addSellCarTransaction(BigDecimal cash, Car car, Client client, Mechanic mechanic, Commercial commercial) {
        transactionList.add(new Transaction(TransactionType.CAR_SALE, cash, car, client, mechanic, commercial));
    }

    public void addBuyCommercialTransaction(BigDecimal cash, Car car, Client client, Mechanic mechanic, Commercial commercial) {
        transactionList.add(new Transaction(TransactionType.COMMERCIAL_PURCHASE, cash, car, client, mechanic, commercial));
    }

    public void addCarRepairTransaction(BigDecimal cash, Car car, Client client, Mechanic mechanic, Commercial commercial) {
        transactionList.add(new Transaction(TransactionType.CAR_REPAIR, cash, car, client, mechanic, commercial));
    }

    public void printTransaction() {
        if (transactionList.isEmpty()) {
            System.err.println("Nie wykonano jeszcze zadnej transakcji! ");
        } else {
            for (int i = 1; i < transactionList.size() + 1; i++) {
                TransactionView transactionView = new TransactionView(i, transactionList.get(i - 1));
                System.out.println(transactionView);
            }
        }
    }


}

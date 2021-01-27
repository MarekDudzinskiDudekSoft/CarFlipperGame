package com.dudek.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionContainer {

    private final List<Transaction> transactionList = new ArrayList<>();

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void addBuyCarTransaction() {
        getTransactionList().add(Transaction.CAR_PURCHASE);
    }

    public void addSellCarTransaction() {
        getTransactionList().add(Transaction.CAR_SALE);
    }

    public void addBuyCommercialTransaction() {
        getTransactionList().add(Transaction.COMMERCIAL_PURCHASE);
    }

    public void addCarRepairTransaction() {
        getTransactionList().add(Transaction.CAR_REPAIR);
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

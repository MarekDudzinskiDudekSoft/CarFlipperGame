package com.dudek.model.Transaction;

public enum Transaction {

    CAR_PURCHASE("Zakup auta"), CAR_SALE("Sprzedaż auta"),COMMERCIAL_PURCHASE("Zakup reklamy"), CAR_REPAIR("Naprawa auta");


    private final String description;

    Transaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return  description;
    }
}

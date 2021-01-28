package com.dudek.model.Transaction;

public enum TransactionType {

    CAR_PURCHASE("Zakup auta"), CAR_SALE("Sprzedaż auta"),COMMERCIAL_PURCHASE("Zakup reklamy"), CAR_REPAIR("Naprawa auta");

    private final String description;

    TransactionType(String description) {
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

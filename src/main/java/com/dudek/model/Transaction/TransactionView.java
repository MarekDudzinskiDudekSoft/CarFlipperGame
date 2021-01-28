package com.dudek.model.Transaction;

public class TransactionView {

    private final long transactionId;
    private final Transaction transactionType;

    public TransactionView(long transactionId, Transaction transaction) {
        this.transactionId = transactionId;
        this.transactionType = transaction;
    }

    @Override
    public String toString() {
        return transactionId + " " + transactionType;
    }
}

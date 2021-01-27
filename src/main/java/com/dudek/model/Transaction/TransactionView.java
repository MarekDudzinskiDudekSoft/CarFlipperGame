package com.dudek.model.Transaction;

public class TransactionView {

    private final long transactionId;
    private final Transaction transaction;

    public TransactionView(long transactionId, Transaction transaction) {
        this.transactionId = transactionId;
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return transactionId + " " + transaction;
    }
}

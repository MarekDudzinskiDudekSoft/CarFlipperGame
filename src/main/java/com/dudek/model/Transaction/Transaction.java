package com.dudek.model.Transaction;

import com.dudek.model.Car.Car;
import com.dudek.model.Client.Client;
import com.dudek.model.Commercial.Commercial;
import com.dudek.model.Mechanic.Mechanic;
import com.dudek.model.Transaction.TransactionDetails.TransactionCar;
import com.dudek.model.Transaction.TransactionDetails.TransactionClient;
import com.dudek.model.Transaction.TransactionDetails.TransactionCommercial;
import com.dudek.model.Transaction.TransactionDetails.TransactionMechanic;

import java.io.Serializable;
import java.math.BigDecimal;

public class Transaction implements Serializable {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private final String uniqueID = java.util.UUID.randomUUID().toString();
    private final TransactionType type;
    private final BigDecimal cashAmount;
    private final TransactionCar car;
    private final TransactionClient client;
    private final TransactionMechanic mechanic;
    private final TransactionCommercial commercial;
    public Transaction(TransactionType type, BigDecimal cashAmount, Car car, Client client, Mechanic mechanic, Commercial commercial) {
        this.type = type;
        this.cashAmount = cashAmount;
        this.car = new TransactionCar(car);
        this.client = new TransactionClient(client);
        this.mechanic = new TransactionMechanic(mechanic);
        this.commercial = new TransactionCommercial(commercial);
    }

    @Override
    public String toString() {

        switch (this.type) {
            case CAR_PURCHASE:
                return (uniqueID + " Typ tranzakcji " + type + " kupione auto: " + car + " kwota: " +ANSI_RED+ cashAmount+ANSI_RESET);

            case CAR_SALE:
                return (uniqueID + " Typ tranzakcji " + type + " Sprzedane auto: " + car + " klient: " + client + " kwota: " +ANSI_GREEN+ cashAmount+ANSI_RESET);

            case CAR_REPAIR:
                return (uniqueID + " Typ tranzakcji " + type + "Naprawione auto: " + car + mechanic + " kwota: " +ANSI_RED+ cashAmount+ANSI_RESET);

            case COMMERCIAL_PURCHASE:
                return (uniqueID + " Typ tranzakcji " + String.format("%8s",type)  + commercial + " kwota: " +ANSI_RED+ cashAmount+ANSI_RESET);

        }
        return "";
    }
}

package com.dudek.model.Transaction.TransactionDetails;

import com.dudek.model.Mechanic.Mechanic;

import java.io.Serializable;

public class TransactionMechanic implements Serializable {

    private String mechanicName;

    public TransactionMechanic(Mechanic mechanic) {
        if(mechanic != null) {
            this.setMechanicName(mechanic.getName());
        }
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    @Override
    public String toString() {
        return "Imie mechanika: " + mechanicName;
    }
}

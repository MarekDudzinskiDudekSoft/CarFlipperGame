package com.dudek.model.Transaction.TransactionDetails;

import com.dudek.model.Mechanic.Mechanic;

public class TransactionMechanic {

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

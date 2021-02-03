package com.dudek.model.Transaction.TransactionDetails;

import com.dudek.model.Commercial.Commercial;

import java.io.Serializable;

public class TransactionCommercial implements Serializable {


    private String type;

    public TransactionCommercial(Commercial commercial) {
        if (commercial != null)
            this.setType(commercial.getName());
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

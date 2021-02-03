package com.dudek.model.Transaction.TransactionDetails;

import com.dudek.model.Client.Client;

import java.io.Serializable;

public class TransactionClient implements Serializable {

    private  String firstName;
    private  String lastName;


    public TransactionClient(Client client) {
        if(client != null) {
            this.setFirstName(client.getFirstName());
            this.setLastName(client.getLastName());
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Imie: " + firstName + " " + "Nazwisko: " + lastName;
    }
}

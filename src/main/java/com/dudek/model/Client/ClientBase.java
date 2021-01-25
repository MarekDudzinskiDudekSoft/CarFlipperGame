package com.dudek.model.Client;

import com.dudek.menu.DataReader;

import java.util.ArrayList;
import java.util.List;

public class ClientBase {

    private final static int initialClientNumber = 5;
    private final List<Client> clientList = new ArrayList<>();

    public ClientBase(ClientGenerator generator) {
        clientList.clear();
        clientList.addAll(generator.generateClients(initialClientNumber));
    }

    public void printList() {
        System.out.println(clientList);
    }

    public void addClientToBase() {
        Client client = new Client();
        clientList.add(client);
    }

    public Client getClientFromBase() {
        System.out.println("Podaj index klienta do pobrania: ");
        int index = DataReader.readOptionFromRange(1, clientList.size());
        return clientList.get(index);
    }


}

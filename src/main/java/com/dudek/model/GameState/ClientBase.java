package com.dudek.model.GameState;

import java.util.List;

public class ClientBase {

    private final static int initialClientNumber = 20;
    private List<Client> clientList;

    public ClientBase(ClientGenerator generator) {
        clientList = generator.generateClients(initialClientNumber);
    }

    public void printList() {
        System.out.println(clientList);
    }

    public void addClientToList() {
        Client client = new Client();
        clientList.add(client);
    }

}

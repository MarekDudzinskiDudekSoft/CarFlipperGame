package com.dudek.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientBase {

    private final static int initialClientNumber = 1000;
    private final List<Client> clientList = new ArrayList<>();

    public ClientBase(ClientGenerator generator) {
        clientList.clear();
        clientList.addAll(generator.generateClients(initialClientNumber));
    }

    public void printList() {
        System.out.println(clientList);
    }

    public void addClientToList() {
        Client client = new Client();
        clientList.add(client);
    }

    public void removeClientFromList(Client client){
        clientList.remove(client);
    }

}

package com.dudek.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientGenerator {

    List<Client> generateClients(int howManyClients) {
        final List<Client> clientList = new ArrayList<>();
        for (int i = 0; i < howManyClients; i++) {
            clientList.add(new Client.ClientRandomizer().getNewRandomClient());
        }

        return clientList;
    }

}

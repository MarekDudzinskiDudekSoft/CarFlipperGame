package com.dudek.model.GameState;

import java.util.ArrayList;
import java.util.List;

  class ClientGenerator {

    private List<Client> clientList = new ArrayList<>();

     List<Client> generateClients(int howManyClients) {
        for (int i = 0; i < howManyClients; i++) {
            clientList.add(new Client());
        }
        return clientList;
    }

}

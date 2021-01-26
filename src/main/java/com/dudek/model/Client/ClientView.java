package com.dudek.model.Client;

public class ClientView {

    private final long clientId;
    private final Client client;

    public ClientView(long carId, Client client) {
        this.clientId = carId;
        this.client = client;
    }

    @Override
    public String toString() {
        return "ID:" + clientId + client;
    }
}

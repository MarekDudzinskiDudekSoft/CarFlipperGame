package com.dudek.model.Commercial;

import java.math.BigDecimal;

public abstract class Commercial {

    private final BigDecimal price;
    private final int clientsInterested;
    private String name;

    public Commercial(String name, BigDecimal price, int clientsInterested) {
        this.price = price;
        this.name = name;
        this.clientsInterested = clientsInterested;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getClientsInterested() {
        return clientsInterested;
    }

    public String getName() {
        return name;
    }
}

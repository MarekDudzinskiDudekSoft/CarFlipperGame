package com.dudek.model.Commercial;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Commercial implements Serializable {

    private final BigDecimal price;
    private final int clientsInterested;
    private final String name;

    protected Commercial(String name, BigDecimal price, int clientsInterested) {
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

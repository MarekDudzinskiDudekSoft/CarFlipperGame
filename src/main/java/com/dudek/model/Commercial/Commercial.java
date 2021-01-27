package com.dudek.model.Commercial;

import java.math.BigDecimal;

public abstract class Commercial {

    private BigDecimal price;
    private int clientsInterested;

    public Commercial(BigDecimal price, int clientsInterested) {
        this.price = price;
        this.clientsInterested = clientsInterested;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getClientsInterested() {
        return clientsInterested;
    }

}

package com.dudek.model.Car;

public enum Brand {

    FIAT("Fiat"), LADA("Lada"), WOLGA("Wolga");

private final String description;

    Brand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

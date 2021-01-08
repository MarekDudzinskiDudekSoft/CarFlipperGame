package com.dudek.model.Car;

public enum Color {


    WHITE("Bialy"), BLUE ("Niebieski"), RED("Czerwony"), BLACK("Czarny, najtanszy");

    private final String description;


    Color(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


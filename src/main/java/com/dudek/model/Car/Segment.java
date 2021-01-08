package com.dudek.model.Car;

public enum Segment {


    BUDGET("Bugdet"), STANDRAD("Standard"), PREMIUM("Premium");

    private final String description;

    Segment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


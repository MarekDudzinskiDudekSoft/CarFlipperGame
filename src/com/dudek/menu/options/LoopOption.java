package com.dudek.menu.options;

import com.dudek.GameState;

public abstract class LoopOption {
    private final int number;
    private final String text;

    protected LoopOption(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    abstract GameState execute();

    @Override
    public String toString() {
        return   number + " - " + text;
    }
}






package com.dudek.menu.options;

import com.dudek.GameState;

public abstract class LoopOption {
    private final int number;
    private final String text;

    protected LoopOption(int number, String text) {
        this.number = number;
        this.text = text;
    }

    int getNumber() {
        return number;
    }

    String getText() {
        return text;
    }

    abstract GameState execute(GameState state);

    @Override
    public String toString() {
        return   number + " - " + text;
    }
}






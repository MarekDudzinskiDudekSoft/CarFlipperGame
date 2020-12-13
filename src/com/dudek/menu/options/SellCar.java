package com.dudek.menu.options;

import com.dudek.GameState;

final class SellCar extends LoopOption {
    SellCar() {
        super(6, "Sprzedaj samochod");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Sprzedaj samochod");
        return null;
    }
}

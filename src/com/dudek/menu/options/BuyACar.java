package com.dudek.menu.options;

import com.dudek.GameState;

final class BuyACar extends LoopOption{
    BuyACar() {
        super(2, "Kup samochod");
    }

    @Override
    GameState execute() {
        System.out.println("Wybrales opcje: Kup auto");return null;
    }
}

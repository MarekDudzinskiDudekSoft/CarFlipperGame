package com.dudek.menu.options;

import com.dudek.GameState;

final class BuyACommercial extends LoopOption{
    BuyACommercial() {
        super(7, "Kup reklame");
    }

    @Override
    GameState execute() {

        System.out.println("Wybrales opcje: Kup reklame");
        return null;
    }
}

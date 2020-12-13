package com.dudek.menu.options;

import com.dudek.GameState;

final class BuyACommercial extends LoopOption{
    BuyACommercial() {
        super(7, "Kup reklame");
    }

    @Override
    GameState execute(GameState state) {

        System.out.println("Wybrales opcje: Kup reklame");
        return null;
    }
}

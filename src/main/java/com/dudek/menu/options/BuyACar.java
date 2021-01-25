package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class BuyACar extends LoopOption {
    BuyACar() {
        super(2, "Kup samochod");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Kup auto");
        System.out.println("Podaj indeks auta do kupienia: ");
        state.buyACar();

        return state;
    }
}

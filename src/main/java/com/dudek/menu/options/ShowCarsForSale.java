package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class ShowCarsForSale extends LoopOption {


    ShowCarsForSale() {
        super(1, "Wyswietl auta na sprzedaz");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Wyswietl auta na sprzedaz");
        state.getCarBase().printCarsForSale();
        return state;
    }
}

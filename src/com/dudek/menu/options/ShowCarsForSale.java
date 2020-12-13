package com.dudek.menu.options;

import com.dudek.GameState;

final class ShowCarsForSale extends LoopOption {


    ShowCarsForSale() {
        super(1, "Wyswietl auta na sprzedaz");
    }

    @Override
    GameState execute() {
        System.out.println("Wybrales opcje: Wyswietl auta na sprzedaz");
        return null;
    }
}

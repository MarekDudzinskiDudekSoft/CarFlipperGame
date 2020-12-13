package com.dudek.menu.options;

import com.dudek.GameState;

final class ShowOwnedCars extends LoopOption {
    ShowOwnedCars() {
        super(3, "Pokaz posiadane samochody");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Pokaz posiadane samochody");
        return null;
    }
}

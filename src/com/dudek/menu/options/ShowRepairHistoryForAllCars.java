package com.dudek.menu.options;

import com.dudek.GameState;

final class ShowRepairHistoryForAllCars extends LoopOption {
    ShowRepairHistoryForAllCars() {
        super(10, "Wyswietl historie napraw aut");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wyswietl historie napraw aut");
        return null;
    }
}

package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class ShowRepairAndWashCost extends LoopOption {
    ShowRepairAndWashCost() {
        super(11, "Pokaz koszt naprawy i umycia auta");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Pokaz koszt naprawy i umycia auta");
        state.calculateTotalRepairAndWashingCost();
        return state;
    }
}

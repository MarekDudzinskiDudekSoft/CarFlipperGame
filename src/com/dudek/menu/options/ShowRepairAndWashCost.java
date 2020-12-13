package com.dudek.menu.options;

import com.dudek.GameState;

final class ShowRepairAndWashCost extends LoopOption {
    ShowRepairAndWashCost() {
        super(11, "Pokaz koszt naprawy i umycia auta");
    }

    @Override
    GameState execute() {
        System.out.println("Wybrales opcje: Pokaz koszt naprawy i umycia auta");
        return null;
    }
}

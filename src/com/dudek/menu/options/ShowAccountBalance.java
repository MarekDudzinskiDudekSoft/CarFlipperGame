package com.dudek.menu.options;

import com.dudek.GameState;

final class ShowAccountBalance extends LoopOption {
    ShowAccountBalance() {
        super(8, "Wyswietl stan konta");
    }

    @Override
    GameState execute() {
        System.out.println("Wybrales opcje: Wyswietl stan konta");
        return null;
    }
}

package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class ShowAccountBalance extends LoopOption {
    ShowAccountBalance() {
        super(8, "Wyswietl stan konta");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Wyswietl stan konta");
        System.out.println(state.getPlayer().getCash());
        return state;
    }
}

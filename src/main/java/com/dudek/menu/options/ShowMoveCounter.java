package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class ShowMoveCounter extends LoopOption {
    ShowMoveCounter() {
        super(12, "Wyswietl liczbę ruchów");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Wyswietl liczbę ruchów");
        System.out.println(state.getMoveCounter());
        return state;
    }
}

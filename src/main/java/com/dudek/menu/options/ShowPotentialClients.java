package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class ShowPotentialClients extends LoopOption {
    ShowPotentialClients() {
        super(5, "Pokaz potencjalnych klientow");
    }

    @Override
    GameState execute(GameState state) {

        System.out.println("Wybrales opcje: Pokaz potencjalnych klientow");
        return null;
    }
}

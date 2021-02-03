package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

class SaveGameState extends LoopOption{

    SaveGameState() {
        super(13, "Zapisz stan gry");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Zapisz stan gry");
        state.saveGameState();
        return state;
    }

}

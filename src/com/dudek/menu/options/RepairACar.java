package com.dudek.menu.options;

import com.dudek.GameState;

final class RepairACar extends LoopOption{

    public RepairACar() {
        super(4, "Napraw auto");
    }

    @Override
    GameState execute() {
        System.out.println("Wybrales opcje: Napraw auto");
        return null;
    }
}

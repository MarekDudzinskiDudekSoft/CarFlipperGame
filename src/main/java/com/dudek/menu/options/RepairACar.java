package com.dudek.menu.options;


import com.dudek.model.GameState.GameState;

final class RepairACar extends LoopOption {

    RepairACar() {
        super(4, "Napraw auto");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Napraw auto");
        if(!state.getPlayer().getOwnedCars().getBrokenCars().isEmpty())
            state.repairCar();
        else{
            System.err.println("Nie posiadasz uszkodzonych aut!");
        }
        return state;

    }
}

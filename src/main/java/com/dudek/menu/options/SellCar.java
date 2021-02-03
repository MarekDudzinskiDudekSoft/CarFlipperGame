package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class SellCar extends LoopOption {
    SellCar() {
        super(6, "Sprzedaj samochod");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Sprzedaj samochod");
        boolean hasAnyCar = state.getPlayer().getOwnedCars().isEmpty();
        if (hasAnyCar) {
            return state;
        } else
            state.sellACar();

        return state;
    }
}

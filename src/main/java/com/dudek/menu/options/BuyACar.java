package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

import java.util.Scanner;

final class BuyACar extends LoopOption {
    BuyACar() {
        super(2, "Kup samochod");
    }

    @Override
    GameState execute(GameState state) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wybrales opcje: Kup auto");
        state.buyACar(input.nextInt());
        return state;
    }
}

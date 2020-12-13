package com.dudek.menu.options;

import com.dudek.GameState;

final class ShowTransactionsHistory extends LoopOption {
    ShowTransactionsHistory() {
        super(9, "Wyswietl historie transakcji");
    }

    @Override
    GameState execute() {
        System.out.println("Wybrales opcje: Wyswietl historie transakcji");
        return null;
    }
}

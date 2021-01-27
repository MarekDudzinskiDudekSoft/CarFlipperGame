package com.dudek.menu.options;

import com.dudek.model.GameState.GameState;

final class ShowTransactionsHistory extends LoopOption {
    ShowTransactionsHistory() {
        super(9, "Wyswietl historie transakcji");
    }

    @Override
    GameState execute(GameState state) {
        System.out.println("Wybrales opcje: Wyswietl historie transakcji");
        state.getTransactions().printTransaction();
        return state;
    }
}

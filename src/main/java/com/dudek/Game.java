package com.dudek;

import com.dudek.menu.Menu;
import com.dudek.model.GameState.GameState;

import java.math.BigDecimal;

class Game {

    private final Menu menu = new Menu();
    public GameState state;

    Game() {
        initialize();
    }

    void play() {
        gameLoop();
    }

    private void initialize() {
        state = new GameState();
    }

    private void welcomeMessage() {
        System.out.println("Witaj w grze symulujacej sklep samochodowy");
    }

    private void gameLoop() {
        welcomeMessage();
        int option;
        do {
            menu.printOptions();
            option = menu.chooseOption();
            menu.executeOption(option, state);
            if (checkWinningCondition(state)) {
                break;
            }
        } while (option != 0);
        System.out.println("Koniec pracy programu");
    }

    private boolean checkWinningCondition(GameState state) {
        BigDecimal winCondition = state.getPlayer().getInitialCash().multiply(BigDecimal.valueOf(2));
        return winCondition.equals(state.getPlayer().getCash());
    }

}


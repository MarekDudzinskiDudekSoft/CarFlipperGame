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
        initialize();
        gameLoop();
    }

    private void initialize() {
       state = new GameState(BigDecimal.valueOf(1000),BigDecimal.valueOf(1000),null,null,5); //smieci
    }

    private void welcomeMessage() {
        System.out.println("Witaj w grze symulujacej sklep samochodowy");
        System.out.println(("Wybierz opcję: "));
    }

    private void gameLoop() {
        welcomeMessage();
        menu.printOptions();
        int option = menu.chooseOption();
        menu.executeOption(option, state);
    }

}


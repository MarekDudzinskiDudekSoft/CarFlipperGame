package com.dudek;

import com.dudek.menu.Menu;
import com.dudek.model.GameState.GameState;

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
        state = new GameState(null); //smieci
    }

    private void welcomeMessage() {
        System.out.println("Witaj w grze symulujacej sklep samochodowy");
        System.out.println(("Wybierz opcję: "));
    }

    private void gameLoop() {
        welcomeMessage();
        int option;
        do {
            menu.printOptions();
            option = menu.chooseOption();
            menu.executeOption(option, state);
        } while (option != 0);
        System.out.println("Koniec pracy programu");
    }

}


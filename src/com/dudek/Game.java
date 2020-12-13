package com.dudek;

import com.dudek.menu.options.LoopOption;
import com.dudek.menu.Menu;

public class Game {

    GameState state;
    private final Menu menu = new Menu();

    public void play() {
        gameLoop();
    }

    private GameState initialize() {
        return null;
    }

    private void welcomeMessage() {
        System.out.println("Witaj w grze symulujacej sklep samochodowy");
        System.out.println(("Wybierz opcję: "));
    }

    private void gameLoop() {
        welcomeMessage();
        menu.printOptions();
        Integer option = menu.chooseOption();
        menu.executeOption(option);
    }

}


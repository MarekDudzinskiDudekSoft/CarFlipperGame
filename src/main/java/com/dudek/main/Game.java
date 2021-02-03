package com.dudek.main;

import com.dudek.file.SerializableFileManager;
import com.dudek.menu.DataReader;
import com.dudek.menu.Menu;
import com.dudek.model.GameState.GameState;

import java.math.BigDecimal;

public class Game {

    private final Menu menu = new Menu();
    private GameState state;

    Game() {
        initialize();
    }

    void play() {
        gameLoop();
    }

    private void initialize() {
        System.out.println("Nowa gra - 1 ");
        System.out.println("Wczytaj gre - 2 ");

        int option = DataReader.readInt();
        switch (option) {
            case 1:
                state = new GameState();
                break;
            case 2:
                state = SerializableFileManager.load();
        }

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

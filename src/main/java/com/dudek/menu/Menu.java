package com.dudek.menu;

import com.dudek.menu.options.AllOptions;
import com.dudek.model.GameState.GameState;

public class Menu {

    private AllOptions allOptions = new AllOptions();
    private MenuOptionReader menuOptionReader;

    public Menu() {
        menuOptionReader = new MenuOptionReader(allOptions.getSize());
    }

    public void printOptions() {
        allOptions.printOptions();
    }

    public int chooseOption() {
        return menuOptionReader.readNumberFromConsole();
    }

    public void executeOption(int option, GameState state){
        allOptions.executeOption(option, state);
    }

}


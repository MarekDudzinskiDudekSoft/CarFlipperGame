package com.dudek.menu;

import com.dudek.menu.options.AllOptions;
import java.util.InputMismatchException;

public class Menu {

    private AllOptions allOptions = new AllOptions();
    private MenuOptionReader menuOptionReader;

    public Menu() {
        menuOptionReader = new MenuOptionReader(allOptions.getSize());
    }

    public void printOptions() {
        allOptions.printOptions();
    }

    public Integer chooseOption() {
        boolean isOk = false;
        Integer option = null;                                            //TODO Tu chyba optionala? help troche spaghetti sie zrobilo, bo jeszcze by tu ifa o zakresie 1-11 wypadaloby dac - to do menuOptionReader
        do {                                                              //try with resources
            try {
                option = menuOptionReader.readNumberFromConsole();
                isOk = true;
            } catch (InputMismatchException e) {
                System.err.println("Podano niepoprawny format danych, sproboj ponownie");
            }
            menuOptionReader.newLine();
        } while (!isOk);
        menuOptionReader.closeReader();
        return option;
    }

    public void executeOption(int option){
        allOptions.executeOption(option);
    }

}


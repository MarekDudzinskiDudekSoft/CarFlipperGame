package com.dudek.menu;

class MenuOptionReader {
    private final int OPTION_SIZE;

    MenuOptionReader(final int size) {
        OPTION_SIZE = size;
    }

    int readNumberFromConsole() {
        System.out.println(("Wybierz opcję: "));
        int option = DataReader.readInt();
        while (validateRangeOfOptions(option)){
            System.err.println("Podaj opcje z zakresu!");
            option = DataReader.readInt();
        }
        return option;
    }

    private  boolean validateRangeOfOptions(int number) {
        return number < 0 || number > OPTION_SIZE;
    }

}

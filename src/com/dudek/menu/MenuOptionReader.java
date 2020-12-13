package com.dudek.menu;

import java.util.Scanner;

class MenuOptionReader {
    private final int OPTION_SIZE;

    MenuOptionReader(final int size) {
        OPTION_SIZE = size;
    }

    private Scanner input = new Scanner(System.in);

    int readNumberFromConsole() {
        int number = input.nextInt();
        while (number < 1 || number > OPTION_SIZE) {
            number = input.nextInt();
        }
        return number;
    }               //TODO dodaj komunikaty o blednym wprowadzeniu,

    String newLine() {
        return input.nextLine();
    }

    void closeReader() {
        input.close();
        input.reset();
    }
}

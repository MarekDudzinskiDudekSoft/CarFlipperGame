package com.dudek.menu;

import java.util.Scanner;

class MenuOptionReader {
    private final int OPTION_SIZE;
    private final static Scanner input = new Scanner(System.in);

    MenuOptionReader(final int size) {
        OPTION_SIZE = size;
    }

    int readNumberFromConsole() {
        int option;
        do {
            option = readOption(input);
        } while (validateRangeOfOptions(option));
        return option;
    }

    private int readOption(Scanner input) {
        while (!input.hasNextInt()) {
            input.next();
        }
        int option = input.nextInt();
        input.nextLine();
        return option;
    }

    private boolean validateRangeOfOptions(int number) {
        return number < 0 || number > OPTION_SIZE;
    }

}

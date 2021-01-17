package com.dudek.menu;

import java.util.Scanner;

class MenuOptionReader {
    private final int OPTION_SIZE;

    MenuOptionReader(final int size) {
        OPTION_SIZE = size;
    }

    int readNumberFromConsole() {                                       // todo walidacja
        Scanner input = new Scanner(System.in);

        try {
            return readOption(input);
        } catch (Exception e) {
            System.err.println("Niepoprawny wybor lub format");
            input.nextLine();
        } finally {
            input.close();
        }
        return readNumberFromConsole();
    }

    private int readOption(Scanner input) {                             //to brzydkie
        String numberInString = input.nextLine();
        int correctNumber = Integer.parseInt(numberInString);
        while (validateRangeOfNumber(correctNumber)) {
            numberInString = input.nextLine();
            correctNumber = Integer.parseInt(numberInString);
        }
        return correctNumber;
    }

    private boolean validateRangeOfNumber(int number) {
        return number < 1 || number > OPTION_SIZE;
    }


}

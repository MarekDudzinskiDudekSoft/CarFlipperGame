package com.dudek.menu;

import java.util.Scanner;

public class DataReader {
    private final static Scanner input = new Scanner(System.in);

    public static int readInt() {
        while (!input.hasNextInt()) {
            System.err.println("Niepoprawny format danych!");
            input.next();
        }
        int option = input.nextInt();
        input.nextLine();
        return option;
    }

    public static int readOptionFromRange(final int min, final int max) {
        int option = readInt();

        while (option < min || option > max) {
            System.out.println("Wybrana opcja jest spoza zakresu: " + min + " - " + max + " sprobuj jeszcze raz.");
            option = readInt();
        }
        return option - 1;
    }

}

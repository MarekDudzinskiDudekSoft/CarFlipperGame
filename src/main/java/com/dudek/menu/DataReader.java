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

}

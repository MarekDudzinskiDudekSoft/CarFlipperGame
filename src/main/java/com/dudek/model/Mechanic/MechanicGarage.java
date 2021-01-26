package com.dudek.model.Mechanic;

import com.dudek.menu.DataReader;

import java.util.ArrayList;
import java.util.List;

public class MechanicGarage {

    private final List<Mechanic> mechanicList = new ArrayList<>();

    public MechanicGarage() {
        this.mechanicList.add(new Janusz());
        this.mechanicList.add(new Marian());
        this.mechanicList.add(new Adrian());
    }

    private void printMechanicOptions() {
        System.out.println("Wybierz mechanika, ktory ma naprawic samochod");
        System.out.println("1 - Janusz - złota rączka");
        System.out.println("2 - Marian - doświadczony w zawodzie");
        System.out.println("3 - Adrian - praktykant");
    }

    public Mechanic chooseMechanic() {
        printMechanicOptions();
        int chosenOption = DataReader.readOptionFromRange(1, mechanicList.size());
        return mechanicList.get(chosenOption);
    }

}

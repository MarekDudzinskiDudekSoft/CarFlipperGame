package com.dudek.model.Commercial;

import com.dudek.menu.DataReader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommercialFactory implements Serializable {

    private final List<Commercial> commercialList = new ArrayList<>();

    public CommercialFactory() {
        commercialList.add(new InternetCommercial());
        commercialList.add(new NewsPaperCommercial());
    }

    private void printCommercialOptions() {
        System.out.println("Wybierz rodzaj reklamy, jaki chcesz kupic: ");
        System.out.println("1 - Reklama w internecie. Tania, ale przyciagnie jednego klienta)");
        System.out.println("2 - Reklama w gazecie. Drozsza, ale istnieje szansa na dodatkowych klientow");
    }

    public Commercial chooseCommercial() {
        printCommercialOptions();
        int chosenOption = DataReader.readOptionFromRange(1, commercialList.size());
        return commercialList.get(chosenOption);
    }

}

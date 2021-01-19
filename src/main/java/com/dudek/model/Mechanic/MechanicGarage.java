package com.dudek.model.Mechanic;

import java.util.ArrayList;
import java.util.List;

public class MechanicGarage {

    private final List<Mechanic> mechanicList = new ArrayList<>();

    public MechanicGarage() {
        this.mechanicList.add(new Janusz());
        this.mechanicList.add(new Marian());
        this.mechanicList.add(new Adrian());
    }

    public List<Mechanic> getMechanicList() {
        return mechanicList;
    }       // todo

    public void chooseAMechanic(){


    }

}

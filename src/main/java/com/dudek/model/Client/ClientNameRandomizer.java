package com.dudek.model.Client;

import com.dudek.model.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class ClientNameRandomizer {

    private final List<String> firstName = new ArrayList<>();
    private final List<String> lastName = new ArrayList<>();

    public ClientNameRandomizer() {
        firstName.add("Marek");
        firstName.add("Michal");
        firstName.add("Jeremiasz");
        firstName.add("Karol");
        firstName.add("Bartosz");
        lastName.add("Dudzinski");
        lastName.add("Kundera");
        lastName.add("Zydowski");
        lastName.add("Figurowski");
        lastName.add("Budziosz");
    }

    public String randomizeFirstName() {
        return firstName.get(Randomizer.createRandomIntFromRange(0,firstName.size()));
    }

    public String randomizeLastName() {
        return lastName.get(Randomizer.createRandomIntFromRange(0,lastName.size()));
    }
}

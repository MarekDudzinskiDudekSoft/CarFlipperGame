package com.dudek.model.Car;

import com.dudek.model.Randomizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Color {


    WHITE("Bialy"), BLUE ("Niebieski"), RED("Czerwony"), BLACK("Czarny");

    private final String description;

    private static final List<Color> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();

    Color(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Color randomColor()  {
        return VALUES.get(Randomizer.random.nextInt(SIZE));
    }

}


package com.dudek.model.Car.CarEnums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {


    WHITE("Bialy"), BLUE ("Niebieski"), RED("Czerwony"), BLACK("Czarny");

    private final String description;

    Color(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static class RandomColor {
        private static final List<Color> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        public static Random random = new Random();

        public static Color randomColor() {
            return VALUES.get(random.nextInt(SIZE));
        }
    }

}


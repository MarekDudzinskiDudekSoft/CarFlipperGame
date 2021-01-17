package com.dudek.model.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Brand {

    FIAT("Fiat"), LADA("Lada"), WOLGA("Wolga");

    private final String description;

    Brand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static class RandomBrand {
        private static final List<Brand> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        public static Random random = new Random();

        public static Brand randomBrand() {
            return VALUES.get(random.nextInt(SIZE));
        }
    }
}

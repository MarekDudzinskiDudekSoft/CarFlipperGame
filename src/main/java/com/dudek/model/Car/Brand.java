package com.dudek.model.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Brand {

    FIAT("Fiat"), LADA("Lada"), WOLGA("Wolga");

    private static final List<Brand> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
private final String description;
    Brand(String description) {
        this.description = description;
    }

    public static Brand randomBrand()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public String getDescription() {
        return description;
    }
}

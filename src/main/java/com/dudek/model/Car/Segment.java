package com.dudek.model.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Segment {


    BUDGET("Bugdet"), STANDRAD("Standard"), PREMIUM("Premium");

    private final String description;

    Segment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static class RandomSegment {
        private static final List<Segment> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        public static Random random = new Random();

        public static Segment randomSegment() {
            return VALUES.get(random.nextInt(SIZE));
        }
    }
}


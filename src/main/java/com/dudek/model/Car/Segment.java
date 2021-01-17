package com.dudek.model.Car;

import com.dudek.model.Randomizer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Segment {


    BUDGET("Bugdet"), STANDRAD("Standard"), PREMIUM("Premium");

    private final String description;

    private static final List<Segment> VALUES =                 //todo anaogicznie do Brand wywalic Randomisera
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();


    Segment(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Segment randomSegment()  {
        return VALUES.get(Randomizer.random.nextInt(SIZE));
    }
}


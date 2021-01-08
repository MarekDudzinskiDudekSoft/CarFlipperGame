package com.dudek.model;

import java.util.concurrent.ThreadLocalRandom;

public class Randomiser {
    public static boolean createBooleanWithTruePropability(int probability) {
        return (ThreadLocalRandom.current().nextInt(0, 100) < probability);
    }
}

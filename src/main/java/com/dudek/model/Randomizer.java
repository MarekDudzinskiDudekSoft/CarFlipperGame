package com.dudek.model;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static boolean createBooleanWithTrueProbability(int probability) {
        return (ThreadLocalRandom.current().nextInt(0, 100) < probability);
    }

    public static BigDecimal createRandomDecimalFromRange(int minBound, int maxBound){
        return BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(minBound, maxBound));
    }

    public static double createRandomDoubleFromRange(double minBound, double maxBound){
        return (ThreadLocalRandom.current().nextDouble(minBound, maxBound));
    }

    public static int createRandomIntFromRange(int minBound, int maxBound){
        return (ThreadLocalRandom.current().nextInt(minBound, maxBound));
    }

}

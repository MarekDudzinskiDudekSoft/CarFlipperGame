package com.dudek.model.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CarTests {
    Car car = new Car();

    @Test
    public void checkIfCarFeeEquals2PercentCarValue() {
        CarFee carFee = new CarFee(car);

        BigDecimal expectedFee = car.getValueWithParts().multiply(BigDecimal.valueOf(0.02));
        Assertions.assertEquals(carFee.getValue(), expectedFee);
    }

    @Test
    public void checkIfBrokenPartsAreImmutable() {
        int sizeBefore = car.getBrokenPartsList().size();
        car.getBrokenPartsList().clear();
        int sizeAfter = car.getBrokenPartsList().size();
        Assertions.assertEquals(sizeAfter, sizeBefore);
    }


}

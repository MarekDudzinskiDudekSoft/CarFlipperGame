package com.dudek.model.car;

import com.dudek.exceptions.IllegalStateOfCarPartException;
import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;
import com.dudek.model.Car.CarParts.Breaks;
import com.dudek.model.Mechanic.Janusz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CarTests {
    Car car = new Car();
    Janusz janusz = new Janusz();
    Breaks breaks = new Breaks();

    @Test
    public void checkIfCarFeeEquals2PercentCarValue() {
        CarFee carFee = new CarFee();

        Assertions.assertEquals(carFee.calculateCarFee(car), car.getValueWithParts().multiply(BigDecimal.valueOf(0.02)));
    }

    @Test
    public void checkIfYouCanAddBrokenPartToRepairedList() {
        Assertions.assertThrows(IllegalStateOfCarPartException.class, () -> car.addRepairedPartToList(breaks));
    }

    @Test
    public void checkIfRepairedPartsAreImmutable() {
        //given
        janusz.repairCarPart(car, breaks);
        car.addRepairedPartToList(breaks);

        //when
        car.getRepairedPartsList().clear();

        //then
        Assertions.assertFalse(car.getRepairedPartsList().isEmpty());
    }


}

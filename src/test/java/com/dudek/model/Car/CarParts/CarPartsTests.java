package com.dudek.model.Car.CarParts;

import com.dudek.exceptions.IllegalStateOfCarPartException;
import com.dudek.model.Car.Car;
import com.dudek.model.Mechanic.Janusz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarPartsTests {

    Janusz janusz = new Janusz();
    Car car = new Car();
    Breaks breaks = new Breaks(false);

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
    }}

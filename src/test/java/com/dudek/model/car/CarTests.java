package com.dudek.model.car;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CarTests {
    Car car = new Car();

    @Test
    public void checkIfCarFeeEquals2PercentCarValue() {
        CarFee carFee = new CarFee();

        Assertions.assertEquals(carFee.calculateCarFee(car), car.getValueWithParts().multiply(BigDecimal.valueOf(0.02)));
    }

    @Test
    public void checkIfCarCommissionIsCalculatedWell() {
        Car car = new Car();
        System.out.println(car);


        BigDecimal price = car.getValueWithParts();
        System.out.println("Cena auta: " + price);

        BigDecimal profitablePrice = car.calculateCarPrice15PercentHigher();
        System.out.println("Cena z zyskiem: " + profitablePrice);

        BigDecimal profit = price.multiply(BigDecimal.valueOf(0.15));
        System.out.println("Zysk: " + profit);

        Assertions.assertEquals((price.add(profit)), profitablePrice);

    }




}

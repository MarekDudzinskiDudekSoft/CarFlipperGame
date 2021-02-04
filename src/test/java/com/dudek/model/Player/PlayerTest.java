package com.dudek.model.Player;

import com.dudek.model.Car.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PlayerTest {

    Player player = new Player();
    Car car = new Car();


    @Test
    public void checkIfCarCommissionIsCalculatedWell() {
        //given
        Car car = new Car();
        System.out.println(car);

        //when
        BigDecimal price = car.getValueWithParts();
        System.out.println("Cena auta: " + price);

        BigDecimal profitablePrice = player.getOwnedCars().calculateCarPrice15PercentHigher(car);
        System.out.println("Cena z zyskiem: " + profitablePrice);

        BigDecimal profit = price.multiply(BigDecimal.valueOf(0.15));
        System.out.println("Zysk: " + profit);

        //then
        Assertions.assertEquals((price.add(profit)), profitablePrice);

    }


}
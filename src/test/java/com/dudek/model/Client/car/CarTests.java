package com.dudek.model.Client.car;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarFee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CarTests {
    Car car = new Car();

/*    @Test
    public void checkIfCarIsTransferredCorrectlyAfterBuy() {
        Player player = new Player();
        CarGenerator generator = new CarGenerator();
        NewCarsDatabase database = new NewCarsDatabase(generator);
        database.generateNewCar();

        player.buyACar(database.getACar());

        Assertions.assertEquals(player.getOwnedCars().getOwnedCarList().get(0), database.getACar());

    }*/

    @Test
    public void checkIfCarIsImmutable1() {
        car.getBrokenPartsList().clear();

        Assertions.assertTrue(car.getBrokenPartsList().isEmpty());
    }

    @Test
    public void checkIfCarIsImmutable2() {
        car.getRepairedPartsList().clear();

        Assertions.assertTrue(car.getRepairedPartsList().isEmpty());
    }

    @Test
    public void checkIfCarFeeEquals2PercentCarValue() {
        CarFee carFee = new CarFee();

        Assertions.assertEquals(carFee.calculateCarFee(car), car.getValueWithParts().multiply(BigDecimal.valueOf(0.02)));
    }

}

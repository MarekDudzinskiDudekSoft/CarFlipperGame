package com.dudek.model.Client;

import com.dudek.model.Car.Car;
import com.dudek.model.Player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ClientTests {

    ClientBase clientBase = new ClientBase(new ClientGenerator());
    Car car = new Car();
    Player player = new Player();

    @Test
    public void checkIfClientWantedBrandsAreImmutable() {
        //given
        Client newRandomClient = new Client.ClientRandomizer().getNewRandomClient();
        int howManyBefore = newRandomClient.getWantedBrands().size();
        //when
        newRandomClient.getWantedBrands().clear();
        //then
        int howManyAfter = newRandomClient.getWantedBrands().size();
        Assertions.assertEquals(howManyAfter, howManyBefore);
    }

    @Test
    public void checkIfClientSpendMoneyProperly(){
        Client client = new Client(BigDecimal.valueOf(1000000),true,true);
        BigDecimal cashBefore = client.getCash();
        client.payForCar(car);
        BigDecimal cashAfter = client.getCash();

        Assertions.assertEquals(cashAfter,cashBefore.subtract(car.getValueWithParts().multiply(BigDecimal.valueOf(1.15))));

    }

}

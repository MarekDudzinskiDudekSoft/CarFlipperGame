package com.dudek.model.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientGeneratorTests {

    ClientGenerator generator = new ClientGenerator();

    @Test
    void checkIf10PercentOfTheClientsAreInterestedInBrokenCarsWith5PercentTolerance() {
        //given
        int howMany = 1000000;
        List<Client> clients = generator.generateClients(howMany);
        long howManyInterestedInBrokenCars = clients.stream().filter(Client::isInterestedInBrokenCars).count();
        //when
        long tolerance = howMany / 20;
        long expectedPercent = 10;

        //then
        System.out.println(howManyInterestedInBrokenCars);
        Assertions.assertTrue(
                (howMany * expectedPercent / 100) - tolerance <= howManyInterestedInBrokenCars
                        &&
                        (howMany * expectedPercent / 100) + tolerance >= howManyInterestedInBrokenCars
        );
    }

}

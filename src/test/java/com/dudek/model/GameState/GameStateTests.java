package com.dudek.model.GameState;

import com.dudek.model.Car.Car;
import com.dudek.model.Client.Client;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Player.Player;
import org.junit.jupiter.api.Test;

public class GameStateTests {

    Player player = new Player();
    Car car = new Car();

    ClientBase clientBase = new ClientBase(new ClientGenerator());


    @Test
    public void checkIfPlayerSellsCarWell() {
        player.getOwnedCars().addCar(car);

       Client client = clientBase.getClientFromBase();
        player.sellACar(car, client);

    }



 // mock na  gameState  Mockito albo spock
}

package com.dudek.model.GameState;

import com.dudek.model.Car.Car;
import com.dudek.model.Client.ClientBase;
import com.dudek.model.Client.ClientGenerator;
import com.dudek.model.Player.PlayerTest;

public class GameStateTests {

    PlayerTest player = new PlayerTest();
    Car car = new Car();

    ClientBase clientBase = new ClientBase(new ClientGenerator());


    // @Test
    // public void checkIfPlayerSellsCarWell() {
    //     player.getOwnedCars().addCar(car);
    //
    //    Client client = clientBase.getClientFromBase();
    //     player.sellACar(player.sellACar(car));        Unable to test, to complex method with private logic inside gamestate
    //                                                   due to this test was changed names in "OwnedCards" methods - add and remove instead of buy and sell
    //
    // }





}

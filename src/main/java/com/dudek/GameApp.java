package com.dudek;

public class GameApp {

    private final static String APP_NAME = "Car Flipper 1.2";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        Game game = new Game();
        game.play();
    }
}

package com.dudek.exceptions;

public class NoCarToSellException extends IllegalArgumentException {
    public NoCarToSellException(String message) {
        super(message);
    }

    public String getMessage(){
        return ("Brak aut na sprzedaz!");
    }
}

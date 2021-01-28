package com.dudek.model.Commercial;

import com.dudek.model.Randomizer;

import java.math.BigDecimal;

public class NewsPaperCommercial extends Commercial{

    public NewsPaperCommercial() {
        super(" Reklama w gazecie", BigDecimal.valueOf(550), Randomizer.createRandomIntFromRange(1,4));
    }

}

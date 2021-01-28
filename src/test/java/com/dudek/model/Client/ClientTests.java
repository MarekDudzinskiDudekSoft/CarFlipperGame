package com.dudek.model.Client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTests {

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
}

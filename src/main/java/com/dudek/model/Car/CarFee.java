package com.dudek.model.Car;

import java.math.BigDecimal;

public class CarFee {

    private final static BigDecimal CAR_FEE_RATE = BigDecimal.valueOf(0.02);
    private final BigDecimal carFee;

    public  CarFee(Car car){
        carFee = car.getValueWithParts().multiply(CAR_FEE_RATE);
    }

    public  BigDecimal getValue() {
        return carFee;
    }

}

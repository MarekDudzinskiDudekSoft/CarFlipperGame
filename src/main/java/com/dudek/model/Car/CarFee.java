package com.dudek.model.Car;

import java.math.BigDecimal;

public class CarFee {

    private final static BigDecimal CAR_FEE = BigDecimal.valueOf(0.02);

    public  BigDecimal getCarFee() {
        return CAR_FEE;
    }

    public  BigDecimal calculateCarFee(Car car){
        return car.getValueWithParts().multiply(getCarFee());
    }


}

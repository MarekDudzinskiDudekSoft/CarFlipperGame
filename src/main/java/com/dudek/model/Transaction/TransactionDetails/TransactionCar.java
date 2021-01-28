package com.dudek.model.Transaction.TransactionDetails;

import com.dudek.model.Car.Car;
import com.dudek.model.Car.CarEnums.Brand;

import java.math.BigDecimal;

public class TransactionCar {

    private BigDecimal value;
    private Brand brand;
    private double mileage;

    public TransactionCar(Car car) {
        if (car != null) {
            setValue(car.getValueWithParts());
            setBrand(car.getBrand());
            setMileage(car.getMileage());
        }
    }

    public void setValue(BigDecimal value) {
            this.value = value;
    }

    public void setBrand(Brand brand) {
            this.brand = brand;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return " Wartosc " + String.format("%.2f",value) + " Marka: " + String.format("%8s",brand) + " Przebieg: " + String.format("%20s",mileage);
    }
}

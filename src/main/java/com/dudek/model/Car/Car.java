package com.dudek.model.Car;

import com.dudek.model.Car.CarParts.*;
import com.dudek.model.Randomizer;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Car {

    private BigDecimal value;
    private Brand brand;
    private Double mileage;
    private Color color;
    private Segment segment;
    private Washing isWashed;

    private Breaks breaks;
    private CarBody carBody;
    private Engine engine;
    private SuspensionSystem suspensionSystem;
    private Transmission transmission;

    public Car() {
        this.value = Randomizer.createRandomDecimalFromRange(15000, 25000);
        this.brand = Brand.RandomBrand.randomBrand();
        this.mileage = Randomizer.createRandomDoubleFromRange(150000, 250000);
        this.color = Color.randomColor();
        this.segment = Segment.randomSegment();

        this.isWashed = new Washing();
        this.breaks = new Breaks();
        this.carBody = new CarBody();
        this.engine = new Engine();
        this.suspensionSystem = new SuspensionSystem();
        this.transmission = new Transmission();
    }

    public BigDecimal getValue() {
        return value;
    }

    public Brand getBrand() {
        return brand;
    }

    public Double getMileage() {
        return mileage;
    }

    public Color getColor() {
        return color;
    }

    public Segment getSegment() {
        return segment;
    }

    public Washing isWashed() {
        return isWashed;
    }

    public Breaks getBreaks() {
        return breaks;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public Engine getEngine() {
        return engine;
    }

    public SuspensionSystem getSuspensionSystem() {
        return suspensionSystem;
    }

    public Transmission getTransmission() {
        return transmission;
    }


    public BigDecimal getValueWithParts() {
        return getPartsList().stream()
                .map(e -> e.calculatePartValue(value))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private List<CarPart> getPartsList() {
        List<CarPart> carPartList = new ArrayList<>();
        carPartList.add(breaks);
        carPartList.add(carBody);
        carPartList.add(engine);
        carPartList.add(suspensionSystem);
        carPartList.add(carBody);

        return carPartList;
    }

    private boolean isNotBroken() {
        return getPartsList().stream()
                .map(CarPart::isOk)
                .allMatch(e -> e = true);
    }

    private void printBrokenParts() {
        getPartsList().stream().filter(e -> !e.isOk()).forEach(System.out::println);
    }

    public boolean canBeSold() {
        return isNotBroken() && isWashed.isDone();
    }

    DecimalFormat df = new DecimalFormat("#.000");

    @Override
    public String toString() {
        return "Cena: " + value.setScale(2, BigDecimal.ROUND_HALF_UP) +
                ", Marka: " + brand.getDescription() +
                ", Przebieg: " + df.format(mileage) +
                ", Kolor: " + color.getDescription() +
                ", Segment" + segment.getDescription() +
                ", Czy umyty :" + isWashed +
                ", Hamulce: " + breaks +
                ", Karoseria: " + carBody +
                ", Silnik: " + engine +
                ", Zawieszenie: " + suspensionSystem +
                ", Skrznia biegów: " + transmission +
                " \n";
    }


}

package com.dudek.model.Car;

import com.dudek.menu.DataReader;
import com.dudek.model.Car.CarParts.*;
import com.dudek.model.Car.CarStatus.Washing;
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
   private final DecimalFormat df = new DecimalFormat("#.000");
    private Engine engine;
    private SuspensionSystem suspensionSystem;
    private Transmission transmission;
    private CarPartBody carBody;

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

    public Car() {
        this.value = Randomizer.createRandomDecimalFromRange(150, 250).multiply(BigDecimal.valueOf(100));
        this.brand = Brand.RandomBrand.randomBrand();
        this.mileage = Randomizer.createRandomDoubleFromRange(150000, 250000);
        this.color = Color.RandomColor.randomColor();
        this.segment = Segment.RandomSegment.randomSegment();

        this.isWashed = new Washing();
        this.breaks = new Breaks();
        this.carBody = new CarPartBody();
        this.engine = new Engine();
        this.suspensionSystem = new SuspensionSystem();
        this.transmission = new Transmission();
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

    public CarPartBody getCarBody() {
        return carBody;
    }

    public boolean isNotBroken() {
        return getPartsList().stream()
                .allMatch(CarPart::isOk);
    }

    private List<CarPart> getPartsList() {
        List<CarPart> carPartList = new ArrayList<>();
        carPartList.add(breaks);
        carPartList.add(carBody);
        carPartList.add(engine);
        carPartList.add(suspensionSystem);
        carPartList.add(transmission);

        return carPartList;
    }

    public void printBrokenParts() {
        System.out.println("Części, które wymagają naprawy: ");
        getPartsList().stream().filter(e -> !e.isOk()).forEach(System.out::println);
    }

    public List<CarPart> getBrokenPartsList() {
        List<CarPart> brokenParts = new ArrayList<>();
        getPartsList().stream().filter(e -> !e.isOk()).forEach(brokenParts::add);

        return brokenParts;
    }

    public CarPart choosePartToRepair(){
        printBrokenParts();
        System.out.println("Wybierz część do naprawy: ");
        int chosenOption = DataReader.readOptionFromRange(1, getBrokenPartsList().size());
        return getBrokenPartsList().get(chosenOption);
    }

    @Override
    public String toString() {
        return "| Cena: " + getValueWithParts() +
                "| Marka: " + brand.getDescription() +
                "| Przebieg: " + df.format(mileage) +
                "| Kolor: " + color.getDescription() +
                "| Segment: " + segment.getDescription() +
                "| Czy umyty :" + isWashed +
                "| " + breaks +
                "| " + carBody +
                "| " + engine +
                "| " + suspensionSystem +
                "| " + transmission;
    }


}

package com.dudek.model.Car;

import com.dudek.exceptions.IllegalStateOfCarPartException;
import com.dudek.menu.DataReader;
import com.dudek.model.Car.CarEnums.Brand;
import com.dudek.model.Car.CarEnums.Color;
import com.dudek.model.Car.CarEnums.Segment;
import com.dudek.model.Car.CarParts.*;
import com.dudek.model.Car.CarWash.Washing;
import com.dudek.model.Randomizer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Car implements Serializable {

    private final BigDecimal value;
    private final Brand brand;
    private final Double mileage;
    private final Color color;
    private final Segment segment;
    private final Washing isWashed;

    private final Breaks breaks;
    private final Engine engine;
    private final SuspensionSystem suspensionSystem;
    private final Transmission transmission;
    private final CarPartBody carBody;
    private final List<CarPart> repairedPartsList = new ArrayList<>();

    public Brand getBrand() {
        return brand;
    }

    public Double getMileage() {
        return mileage;
    }

    public Washing getIsWashed() {
        return isWashed;
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

    public Engine getEngine() {
        return engine;
    }

    public SuspensionSystem getSuspensionSystem() {
        return suspensionSystem;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public CarPartBody getCarBody() {
        return carBody;
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

    public BigDecimal getValueWithParts() {
        return getPartsList().stream()
                .map(e -> e.calculatePartValue(value))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
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
        getPartsList().stream().filter(e -> !e.isOk()).forEach(System.out::println);
    }

    public List<CarPart> getBrokenPartsList() {
        return getPartsList().stream().filter(e -> !e.isOk()).collect(Collectors.toList());
    }

    public List<CarPart> getRepairedPartsList() {
        return new ArrayList<>(repairedPartsList);
    }

    public void addRepairedPartToList(CarPart carPart) {
        if (carPart.isOk())
            repairedPartsList.add(carPart);
        else
            throw new IllegalStateOfCarPartException("Nie możesz dodać uszkodzonej części do listy naprawionych! ");
    }

    public void printRepairedCarParts() {
        if (getRepairedPartsList().isEmpty()) {
            System.err.println("W aucie nie byly dokonywane zadne naprawy! ");
        } else {
            System.out.println("W aucie: " + this.getBrand() + " " + this.color + " " + this.mileage + "bylo naprawiane: ");
            for (CarPart carPart : getRepairedPartsList()) {
                System.out.println(carPart.getName());
            }
            System.out.println();
        }
    }

    public CarPart choosePartToRepair() {
        printBrokenParts();
        System.out.println("Wybierz część do naprawy: ");
        int chosenOption = DataReader.readOptionFromRange(1, getBrokenPartsList().size());
        return getBrokenPartsList().get(chosenOption);
    }

    public void printRepairAndWashCost() {
        BigDecimal totalPrice = new BigDecimal(0);
        List<CarPart> parts = getBrokenPartsList();
        for (CarPart part : parts) {
            totalPrice = totalPrice.add(calculateCartPartPrice(part));
        }
        System.out.println("Calkowity koszt wynosi: " + totalPrice.add(getIsWashed().getPrice()) + " z czego naprawa wynosi: " + totalPrice + " a umycie: " + getIsWashed().getPrice());
    }

    private BigDecimal calculateCartPartPrice(CarPart carPart) {
        BigDecimal price = new BigDecimal(0);
        if (this.getSegment().equals(Segment.PREMIUM)) {
            price = carPart.getBaseValue().multiply(BigDecimal.valueOf(2));
        }

        if (this.getSegment().equals(Segment.STANDRAD)) {
            price = carPart.getBaseValue().multiply(BigDecimal.valueOf(1.5));
        }

        if (this.getSegment().equals(Segment.BUDGET)) {
            price = carPart.getBaseValue().multiply(BigDecimal.valueOf(1.1));
        }

        return price;
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("#.000");
        return "| Cena: " + getValueWithParts() +
                "| Marka: " + brand.getDescription() +
                "| Przebieg: " + df.format(getMileage()) +
                "| Kolor: " + color.getDescription() +
                "| Segment: " + segment.getDescription() +
                "| Czy umyty :" + getIsWashed() +
                "| " + getBreaks() +
                "| " + getCarBody() +
                "| " + getEngine() +
                "| " + getSuspensionSystem() +
                "| " + getTransmission();
    }

}

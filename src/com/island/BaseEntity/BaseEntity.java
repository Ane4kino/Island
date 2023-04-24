package com.island.BaseEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.Actions.*;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntityPopulation;
import com.island.frame.Cell;
import com.island.frame.Sign;

import java.util.Map;


public abstract class BaseEntity implements Sign, Eating, Reproduce, Die, AnimalType, Name {
    private String name;
    private String icon;
    private int age;
    private int maxAge;
    private int movementRange;//диапазон движения
    private int breedingAge;//возраст размножения
    private int maxNumber;//максимальное количество на ячейке
    private double breedingProbability;//вероятность размножения
    private double weight;
    private double kilogramToSaturation;// максимальное значение насыщения
    protected boolean isAlive;
    protected AnimalPosition position;

    public String getIcon() {
        return icon;
    }

    public int getAge() {
        return age;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public int getBreedingAge() {
        return breedingAge;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public String getName() {
        return name;
    }

    public BaseEntity() {
    }
    @JsonCreator
    public BaseEntity(String name, String icon, int age, int maxAge, int movementRange, int breedingAge, int maxNumber,
                      double breedingProbability, double weight, double kilogramToSaturation, boolean isAlive) {
        this.name = name;
        this.icon = icon;
        this.age = age;
        this.maxAge = maxAge;
        this.movementRange = movementRange;
        this.breedingAge = breedingAge;
        this.maxNumber = maxNumber;
        this.breedingProbability = breedingProbability;
        this.weight = weight;
        this.kilogramToSaturation = kilogramToSaturation;
        this.isAlive = true;
    }

    //    public BaseEntity(boolean isAlive, AnimalPosition position) {
//        this.isAlive = isAlive;
//        this.position = position;
//    }

    public BaseEntity(boolean isAlive, AnimalPosition position, String filePath) {
//        Wolf wolf = objectMapper.readValue(new File(filePath), Wolf.class);
        this.isAlive = isAlive;
        this.position = position;
        this.name = name;
        this.icon = icon;
        this.age = age;
        this.maxAge = maxAge;
        this.movementRange = movementRange;
        this.breedingAge = breedingAge;
        this.maxNumber = maxNumber;
        this.breedingProbability = breedingProbability;
        this.weight = weight;
        this.kilogramToSaturation = kilogramToSaturation;
    }
    public abstract AnimalTypeEnum getType();
//    public void setPosition(int newX, int newY) {
//        this.position = new AnimalPosition(newX, newY);
//    }

    public AnimalPosition getPosition() {
        return position;
    }
    @Override
    public void eat() {
    }

    @Override
    public void die() {
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", age=" + age +
                ", movementRange=" + movementRange +
                ", breedingAge=" + breedingAge +
                ", maxNumber=" + maxNumber +
                ", breedingProbability=" + breedingProbability +
                ", weight=" + weight +
                ", kilogramToSaturation=" + kilogramToSaturation +
                ", isAlive=" + isAlive +
                ", maxAge=" + maxAge +
                ", position=" + position +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public double getKilogramToSaturation() {
        return kilogramToSaturation;
    }
}


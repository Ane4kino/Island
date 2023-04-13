package com.island.BaseEntity;

import com.island.Actions.*;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntityPopulation;
import com.island.frame.Sign;

import java.util.Map;


public abstract class BaseEntity implements Sign, Movable, Eating, Reproduce, Die, AnimalType, Name {
    private int age;
    private boolean isAlive;
    private int movementRange;//диапазон движения
    private int breedingAge;//возраст размножения
    private int maxAge;//макс возраст
    private double breedingProbability;//вероятность размножения
    private int maxLitterSize;//максимальный вес съеденного
    private int maxNumber;//максимальное количество на ячейке
    private String name;
    private double weight;//вес
    private Map<BaseEntityPopulation, Integer> eatingMap;
    private int kilogramToSaturation;
    private int maxSaturation; // максимальное значение насыщения

    public BaseEntity(int age, boolean isAlive, AnimalPosition position) {
        this.age = age;
        this.isAlive = isAlive;
        this.position = position;
    }

    public BaseEntity(int age, boolean isAlive, int movementRange, int breedingAge, int maxAge, double breedingProbability, int maxLitterSize, int maxNumber, String name, double weight, Map<BaseEntityPopulation, Integer> eatingMap, int kilogramToSaturation, AnimalPosition position) {
        this.age = age;
        this.isAlive = isAlive;
        this.movementRange = movementRange;
        this.breedingAge = breedingAge;
        this.maxAge = maxAge;
        this.breedingProbability = breedingProbability;
        this.maxLitterSize = maxLitterSize;
        this.maxNumber = maxNumber;
        this.name = name;
        this.weight = weight;
        this.eatingMap = eatingMap;
        this.kilogramToSaturation = kilogramToSaturation;
        this.position = position;
    }


    public abstract AnimalTypeEnum getType();

    private AnimalPosition position;

    public void setPosition(AnimalPosition position) {
        this.position = position;
    }

    public AnimalPosition getPosition() {
        return position;
    }

    public int getMovementRange() {
        return movementRange;
    }

    @Override
    public void eat() {
    }

    @Override
    public void die() {
    }

    public void setX(int newX) {
    }

    public void setY(int newY) {
    }
}

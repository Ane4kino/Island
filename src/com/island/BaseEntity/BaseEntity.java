package com.island.BaseEntity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.*;
import com.island.Actions.*;
import com.island.BaseEntity.Herbivores.Horse;
import com.island.BaseEntity.Herbivores.Mouse;
import com.island.BaseEntity.Predators.Fox;
import com.island.BaseEntity.Predators.Wolf;
import com.island.frame.AnimalGrid;
import com.island.frame.Cell;
import com.island.frame.Direction;
import com.island.frame.Sign;

import java.util.HashMap;
import java.util.Map;

import static com.island.Constants.*;


public abstract class BaseEntity implements Sign, Eating, Reproduce, Die, AnimalType, Name {
    protected ObjectMapper objectMapper;
    private String icon;
    private String name;
    private int age;
    private int movementRange;//диапазон движения
    private int breedingAge;//возраст размножения
    private int maxNumber;//максимальное количество на ячейке
    private double breedingProbability;//вероятность размножения
    private int weight;
    private int kilogramToSaturation;// максимальное значение насыщения
    protected boolean isAlive;
    private int maxAge;//макс возраст
    private Cell currentCell;
    private Map<BaseEntityPopulation, Integer> eatingMap;
    protected AnimalPosition position;

    @Override
    public String getName() {
        return name;
    }
    public BaseEntity() {
    }
    public BaseEntity(boolean isAlive, AnimalPosition position) {
        this.isAlive = isAlive;
        this.position = position;
    }
    @JsonCreator
    public BaseEntity(String name, int age, int movementRange, int breedingAge, int maxNumber, double breedingProbability, int weight, int kilogramToSaturation, boolean isAlive, int maxAge, Map<BaseEntityPopulation, Integer> eatingMap, AnimalPosition position, Cell currentCell) {
        this.name = name;
        this.age = age;
        this.movementRange = movementRange;
        this.breedingAge = breedingAge;
        this.maxNumber = maxNumber;
        this.breedingProbability = breedingProbability;
        this.weight = weight;
        this.kilogramToSaturation = kilogramToSaturation;
        this.isAlive = isAlive;
        this.maxAge = maxAge;
        this.eatingMap = eatingMap;
        this.position = position;
        this.currentCell = currentCell;
    }
    public abstract AnimalTypeEnum getType();
    public void setPosition(int newX, int newY) {
        this.position = new AnimalPosition(newX, newY);
    }
//    public void setPosition(AnimalGrid animalGrid, int newX, int newY) {
//        AnimalPosition oldPosition = position;
//        AnimalPosition newPosition = new AnimalPosition(newX, newY);
//
//        // Удаляем сущность с ее старой позиции
//        animalGrid.getCell(oldPosition.getX(), oldPosition.getY()).removeEntity(this);
//
//        // Устанавливаем новую позицию для сущности
//        position = newPosition;
//
//        // Добавляем сущность на новую позицию
//        animalGrid.getCell(newX, newY).addEntity(this);
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
                ", currentCell=" + currentCell +
                ", eatingMap=" + eatingMap +
                ", position=" + position +
                '}';
    }
}


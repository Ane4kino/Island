package com.island.BaseEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.island.*;
import com.island.Actions.*;
import com.island.frame.Direction;
import com.island.frame.Sign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.island.Constants.*;


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
    @JsonCreator
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

    public void setPosition(AnimalPosition newPosition) {
        this.position = newPosition;
    }

    public AnimalPosition getPosition() {
        return position;
    }



    @Override
    public void eat() {
    }

    @Override
    public void die() {
    }
    public void move(BaseEntityPopulation population) {

        for (BaseEntity base : population.getBaseEntity()) {
            // определение новых координат на основе текущих координат и количества шагов
            Direction randomMove = setRandomMove();
            int newX = base.position.getX() + (randomMove == Direction.LEFT ? -base.getMovementRange() : (randomMove == Direction.RIGHT ? base.getMovementRange() : 0));
            int newY = base.position.getY() + (randomMove == Direction.UP ? -base.getMovementRange() : (randomMove == Direction.DOWN ? base.getMovementRange() : 0));
// проверка на возможность перемещения на новую позицию
            if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                // обновление координат животного
                base.setPosition(new AnimalPosition(newX,newY));
            }
        }
    }
    private static Direction setRandomMove() {
        int randomBehavior = (int) (Math.random() * 4) + 1;
        Direction key = null;
        if (randomBehavior == 1)
            key = Direction.LEFT;
        else if (randomBehavior == 2)
            key = Direction.RIGHT;
        else if (randomBehavior == 3)
            key = Direction.UP;
        else if (randomBehavior == 4)
            key = Direction.DOWN;
        return key;
    }
    private Cell currentCell; // Поле для хранения текущей ячейки

    // Метод для установки текущей ячейки
    public void setCurrentCell(Cell cell) {
        this.currentCell = cell;
    }

    // Метод для получения текущей ячейки
    public Cell getCurrentCell() {
        return currentCell;
    }


}


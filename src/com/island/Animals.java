package com.island;

import com.island.Actions.*;
import com.island.frame.Direction;
import com.island.frame.Sign;
import com.island.frame.StartPosition;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;
import static com.island.frame.StartPosition.randomStart;

public abstract class Animals implements Sign, Movement, Eating, Reproduce, Die, AnimalType, PositionAnimals {
    private String name;
    private int weightAnimals;
    private int maxNumberAnimals;
    private int speed;
    private int ateAnimals;

    public Animals(int weightAnimals, int maxNumberAnimals, int speed, int ateAnimals, String name) {
        this.weightAnimals = weightAnimals;
        this.maxNumberAnimals = maxNumberAnimals;
        this.speed = speed;
        this.ateAnimals = ateAnimals;
        this.name = name;
    }

    public Animals() {

    }

    @Override
    public void eat() {
    }

    @Override
    public void die() {
    }

}

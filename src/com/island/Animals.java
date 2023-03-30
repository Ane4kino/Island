package com.island;

import com.island.Actions.*;
import com.island.frame.Direction;
import com.island.frame.Sign;
import com.island.frame.StartPosition;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;
import static com.island.frame.StartPosition.randomStart;

public abstract class Animals implements Sign, Movement, Eating, Reproduce, Die, AnimalType, PositionAnimals {

    private int x = randomStart.nextInt(WIDTH);

    private int y = randomStart.nextInt(HEIGHT);

    public Animals(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Animals() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void eat() {
    }

    @Override
    public void die() {
    }

}

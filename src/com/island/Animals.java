package com.island;

import com.island.Actions.*;
import com.island.frame.Direction;
import com.island.frame.Sign;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;

public abstract class Animals implements Sign, Movable , Eating, Reproduce, Die, AnimalType, PositionAnimals {
    private int x;
    private int y;
    public abstract AnimalTypeEnum getType();
    private AnimalPosition position;
    public AnimalPosition getPosition() {
        return position;
    }
    public void setPosition(AnimalPosition position) {
        this.position = position;
    }
    public Animals(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void move() {

        List<AnimalPosition> newPositions = new ArrayList<>();
        for (AnimalPosition position : positions) {
            Direction direction = Direction.getRandomDirection();
            int newX = position.getX() + direction.getXOffset();
            int newY = position.getY() + direction.getYOffset();

            if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {

                AnimalPosition newPosition = new AnimalPosition(newX, newY);
                newPositions.add(newPosition);
            } else {

                newPositions.add(position);
            }
        }

        positions = newPositions;
    }



    public void moveRandom(Animals animals) {
        Random random = new Random();
        int distance = animal.getMoveDistance();
        int direction = random.nextInt(4);

        switch (direction) {
            case 0: // up
                animal.setY(animal.getY() - distance);
                break;
            case 1: // down
                animal.setY(animal.getY() + distance);
                break;
            case 2: // left
                animal.setX(animal.getX() - distance);
                break;
            case 3: // right
                animal.setX(animal.getX() + distance);
                break;
            default:
                break;
        }
    }

    public int getMovementRange() {
        return 1;
    }


    @Override
    public void eat() {
    }

    @Override
    public void die() {
    }

}

package com.island;

import com.island.Actions.*;
import com.island.frame.Direction;
import com.island.frame.Sign;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;

public abstract class Animals implements Sign, Movable, Eating, Reproduce, Die, AnimalType {
    private int age;
    private boolean isAlive;
    private int movementRange;
    private int breedingAge;
    private int maxAge;
    private double breedingProbability;
    private int maxLitterSize;
    private int maxNumber;

    public Animals(int age, boolean isAlive, AnimalPosition position) {
        this.age = age;
        this.isAlive = isAlive;
        this.position = position;
    }

    public Animals(int age, boolean isAlive, int movementRange, int breedingAge, int maxAge, double breedingProbability, int maxLitterSize, int maxNumber) {
        this.age = age;
        this.isAlive = isAlive;
        this.movementRange = movementRange;
        this.breedingAge = breedingAge;
        this.maxAge = maxAge;
        this.breedingProbability = breedingProbability;
        this.maxLitterSize = maxLitterSize;
        this.maxNumber = maxNumber;
    }


    public abstract AnimalTypeEnum getType();

    private AnimalPosition position;

    public AnimalPosition getPosition() {
        return position;
    }

    public List<AnimalPosition> move(AnimalPosition position, AnimalGrid animalGrid) {
        List<AnimalPosition> positions = animalGrid.getPositions(this);
        List<AnimalPosition> newPositions = new ArrayList<>();
        for (AnimalPosition currPosition : positions) {
            for (int i = 0; i < getMovementRange(); i++) {
                Direction direction = Direction.getRandomDirection();
                int newX = currPosition.getX() + direction.getXOffset();
                int newY = currPosition.getY() + direction.getYOffset();
                if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                    AnimalPosition newPosition = animalGrid.getAnimalPosition(newX, newY);
                    if (newPosition.isEmpty()) {
                        newPositions.add(newPosition);
                    }
                }
            }
        }
        animalGrid.moveAnimals(position, newPositions, this);
        return positions;
    }
  //  public abstract void move(List<AnimalPosition> adjacentPositions);

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

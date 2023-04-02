package com.island.animals;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.Animals;

import java.util.List;

import static com.island.AnimalTypeEnum.FOX;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;

public class Fox extends Animals {
    private static final int MOVEMENT_RANGE = 2;
    private static final int BREEDING_AGE = 2;
    private static final int MAX_AGE = 6;
    private static final double BREEDING_PROBABILITY = 0.5;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 12) + 5;
    private static final int MAX_NUMBER = 30;

    public Fox(int age, boolean isAlive) {
        super(age, isAlive, MOVEMENT_RANGE, BREEDING_AGE, MAX_AGE, BREEDING_PROBABILITY, MAX_LITTER_SIZE, MAX_NUMBER);
    }
    public Fox(int age, boolean isAlive, AnimalPosition position) {
        super(age, isAlive, position);
    }
//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }

    @Override
    public String getSymbol() {
        return "\uD83E\uDD8A";
    }

    @Override
    public int getReproduce() {
        return AMT_FOX_CUB;
    }

    @Override
    public int getMovementRange() {
        return 2;
    }

    @Override
    public AnimalTypeEnum getType() {
        return FOX;
    }

}

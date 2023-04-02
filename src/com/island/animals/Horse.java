package com.island.animals;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.Animals;

import java.util.List;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;

public class Horse extends Animals {
    private static final int MOVEMENT_RANGE = 4;
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 20;
    private static final double BREEDING_PROBABILITY = 0.5;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 2) + 1;
    private static final int MAX_NUMBER = 20;
    private static final String SYMBOL="\uD83D\uDC34";

    public Horse(int age, boolean isAlive) {
        super(age, isAlive, MOVEMENT_RANGE, BREEDING_AGE, MAX_AGE, BREEDING_PROBABILITY, MAX_LITTER_SIZE, MAX_NUMBER);

    }

    public Horse(int age, boolean isAlive, AnimalPosition position) {
        super(age, isAlive, position);
        this.getSymbol();
    }

    @Override
    public String getSymbol() {
        return "\uD83D\uDC0E";
    }

    @Override
    public int getReproduce() {
        return AMT_HORSE_CUB;
    }

    @Override
    public int getMovementRange() {
        return 4;
    }

    @Override
    public AnimalTypeEnum getType() {
        return HORSE;
    }

//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }
}

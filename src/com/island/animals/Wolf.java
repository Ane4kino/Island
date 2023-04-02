package com.island.animals;

import com.island.AnimalGrid;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.Animals;
import com.island.frame.Direction;

import java.util.ArrayList;
import java.util.List;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class Wolf extends Animals {
    private static final int MOVEMENT_RANGE = 3;
    private static final int BREEDING_AGE = 2;
    private static final int MAX_AGE = 5;
    private static final double BREEDING_PROBABILITY = 0.5;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 8) + 4;
    private static final int MAX_NUMBER = 30;

    public Wolf(int age, boolean isAlive) {
        super(age, isAlive, MOVEMENT_RANGE, BREEDING_AGE, MAX_AGE, BREEDING_PROBABILITY, MAX_LITTER_SIZE, MAX_NUMBER);
    }
    public Wolf(int age, boolean isAlive, AnimalPosition position) {
        super(age, isAlive, position);
    }
    @Override
    public String getSymbol() {
        return "\uD83D\uDC3A";
    }

    @Override
    public int getReproduce() {
        return AMT_WOLF_CUB;
    }

    @Override
    public int getMovementRange() {
        return 3;
    }

    @Override
    public AnimalTypeEnum getType() {
        return WOLF;
    }




//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }

}

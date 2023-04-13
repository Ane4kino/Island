package com.island.BaseEntity.Predators;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class Wolf extends BaseEntity {
    private static final int MOVEMENT_RANGE = 3;
    private static final int BREEDING_AGE = 2;
    private static final int MAX_AGE = 5;
    private static final double BREEDING_PROBABILITY = 0.5;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 8) + 4;
    private static final int MAX_NUMBER = 30;


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
        return MOVEMENT_RANGE;
    }

    @Override
    public AnimalTypeEnum getType() {
        return WOLF;
    }

    @Override
    public String getName() {
        return "волк(ов)";
    }


//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }

}

package com.island.BaseEntity.Herbivores;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class Mouse extends BaseEntity {

    private static final int MOVEMENT_RANGE = 1;
    private static final int BREEDING_AGE = 1;
    private static final int MAX_AGE = 2;
    private static final double BREEDING_PROBABILITY = 0.8;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 12) + 5;
    private static final int MAX_NUMBER = 500;


    public Mouse(int age, boolean isAlive, AnimalPosition position) {
        super(age, isAlive, position);
    }
    @Override
    public String getSymbol() {
        return "\uD83D\uDC01";
    }

    @Override
    public int getReproduce() {
        return AMT_MOUSE_CUB;
    }

    @Override
    public int getMovementRange() {
        return MOVEMENT_RANGE;
    }

    @Override
    public AnimalTypeEnum getType() {
        return MOUSE;
    }

    @Override
    public String getName() {
        return "Мышь(ей)";
    }

//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {

//    }


}

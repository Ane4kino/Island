package com.island.BaseEntity.Herbivores;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.*;
import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class Horse extends BaseEntity {
    private static final int MOVEMENT_RANGE = 4;
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 20;
    private static final double BREEDING_PROBABILITY = 0.5;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 2) + 1;
    private static final int MAX_NUMBER = 20;
    private static final String SYMBOL="\uD83D\uDC34";

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
        return MOVEMENT_RANGE;
    }

    @Override
    public AnimalTypeEnum getType() {
        return HORSE;
    }

    @Override
    public String getName() {
        return "лошадь(ей)";
    }

//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }
}

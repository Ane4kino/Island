package com.island.BaseEntity.Predators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;
import static com.island.AnimalTypeEnum.FOX;
import static com.island.Constants.*;

public class Fox extends BaseEntity {
    private static final int MOVEMENT_RANGE = 2;
    private static final int BREEDING_AGE = 2;
    private static final int MAX_AGE = 6;
    private static final double BREEDING_PROBABILITY = 0.5;
    private static final int MAX_LITTER_SIZE = (int) (Math.random() * 12) + 5;
    private static final int MAX_NUMBER = 30;

    public Fox(int age, boolean isAlive, AnimalPosition position) {
        super(age, isAlive, position);
    }

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
        return MOVEMENT_RANGE;
    }

    @Override
    public AnimalTypeEnum getType() {
        return FOX;
    }

    @Override
    public String getName() {
        return "лис(а)";
    }
}

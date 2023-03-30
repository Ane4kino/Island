package com.island.animals;

import com.island.AnimalTypeEnum;
import com.island.Animals;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;

public class Horse extends Animals {

    public Horse(int x, int y) {

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
    public int getMovement() {
        return 4;
    }

    @Override
    public AnimalTypeEnum getType() {
        return HORSE;
    }

    @Override
    public int positionX() {
        return randomStart.nextInt(WIDTH);
    }

    @Override
    public int positionY() {
        return randomStart.nextInt(HEIGHT);
    }
}

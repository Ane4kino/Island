package com.island.animals;

import com.island.AnimalTypeEnum;
import com.island.Animals;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;

public class Wolf extends Animals {

    public Wolf(int x, int y) {
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
    public int getMovement() {
        return 3;
    }

    @Override
    public AnimalTypeEnum getType() {
        return WOLF;
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

package com.island.animals;

import com.island.AnimalTypeEnum;
import com.island.Animals;
import static com.island.AnimalTypeEnum.FOX;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;

public class Fox extends Animals {
    public Fox(int weightAnimals, int maxNumberAnimals, int speed, int ateAnimals) {
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
    public int getMovement() {
        return 2;
    }

    @Override
    public AnimalTypeEnum getType() {
        return FOX;
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

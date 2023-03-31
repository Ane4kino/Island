package com.island.animals;

import com.island.AnimalTypeEnum;
import com.island.Animals;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;
public class Mouse extends Animals {

    public Mouse(int x, int y) {
        super(x,y);

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
        return 1;
    }

    @Override
    public AnimalTypeEnum getType() {
        return MOUSE;
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

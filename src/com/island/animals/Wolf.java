package com.island.animals;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.Animals;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.randomStart;

public class Wolf extends Animals {
    public Wolf(AnimalPosition position) {
        super(position);
        this.type = "Волк";
        this.symbol = "\uD83D\uDC3A";
    }

    @Override
    public void move() {
        int newX = position.getX() + 3;
        int newY = position.getY() + 3;
        position.setX(newX);
        position.setY(newY);
    }

    public Wolf(int x, int y) {
        super(x,y);
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


    @Override
    public int positionX() {
        return randomStart.nextInt(WIDTH);
    }

    @Override
    public int positionY() {
        return randomStart.nextInt(HEIGHT);
    }
}

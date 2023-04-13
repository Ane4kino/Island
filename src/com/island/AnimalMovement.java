package com.island;

import com.island.BaseEntity.BaseEntity;
import com.island.frame.Direction;

import java.util.List;
import com.island.Actions.*;

public class AnimalMovement {

    public static void moveAnimals(List<BaseEntity> baseEntities) {
        for (BaseEntity animal : baseEntities) {
            if (animal != null) {
                int movementRange = animal.getMovementRange();
                Direction direction = setRandomMove();
                int newX = animal.getPosition().getX() + (direction == Direction.LEFT ? -movementRange : (direction == Direction.RIGHT ? movementRange : 0));
                int newY = animal.getPosition().getY() + (direction == Direction.UP ? -movementRange : (direction == Direction.DOWN ? movementRange : 0));

                // Обновление позиции животного на острове
                animal.setPosition(new AnimalPosition(newX,newY));
            }
        }
    }
    private static Direction setRandomMove() {
        int randomBehavior = (int) (Math.random() * 4) + 1;
        Direction key = null;
        if (randomBehavior == 1)
            key = Direction.LEFT;
        else if (randomBehavior == 2)
            key = Direction.RIGHT;
        else if (randomBehavior == 3)
            key = Direction.UP;
        else if (randomBehavior == 4)
            key = Direction.DOWN;
        return key;
    }
}


package com.island;

import com.island.frame.Direction;

import java.util.ArrayList;
import java.util.List;

import static com.island.AnimalTypeEnum.*;
import static com.island.AnimalTypeEnum.MOUSE;
import static com.island.frame.Direction.*;

public class BehaviorAnimals {
    private Direction direction = Direction.LEFT;

    public static List<Animals> createAnimals() {
        AnimalFactory factory = new AnimalFactory();
        Animals fox = factory.createAnimal(FOX);
        Animals wolf = factory.createAnimal(WOLF);
        Animals horse = factory.createAnimal(HORSE);
        Animals mouse = factory.createAnimal(MOUSE);

        List<Animals> listOfAllAnimals = new ArrayList<>();
        listOfAllAnimals.add(fox);
        listOfAllAnimals.add(wolf);
        listOfAllAnimals.add(horse);
        listOfAllAnimals.add(mouse);
        return listOfAllAnimals;
    }

//    public void setDirection(Direction direction) {
//        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && createAnimals().get(0).positionX() == createAnimals().get(1).positionX()) {
//            return;
//        }
//        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && createAnimals().get(0).positionY() == createAnimals().get(1).positionY()) {
//            return;
//        }
//
//        if (direction == Direction.UP && this.direction == Direction.DOWN) {
//            return;
//        } else if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
//            return;
//        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
//            return;
//        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
//            return;
//        }
//
//        this.direction = direction;
//    }

    public static Direction setRandomMove() {
        int randomBehavior = (int) (Math.random() * 4) + 1;
        Direction key = null;
        if (randomBehavior == 1)
            key = LEFT;
        else if (randomBehavior == 2)
            key = RIGHT;
        else if (randomBehavior == 3)
            key = UP;
        else if (randomBehavior == 4)
            key = DOWN;
        return key;
    }

    public static Animals setMove(Animals listOfAllAnimals) {

        for (int i = 0; i < createAnimals().size(); i++) {
            if (setRandomMove().equals(LEFT))
                createAnimals().get(i).positionX() = createAnimals().get(i).positionX() - 1;
            else if (setRandomMove().equals(RIGHT))
                createAnimals().get(i).positionX() = createAnimals().get(i).positionX() + 1;
            else if (setRandomMove().equals(UP))
                createAnimals().get(i).positionY() = createAnimals().get(i).positionY() + 1;
            else if (setRandomMove().equals(DOWN))
                createAnimals().get(i).positionY() = createAnimals().get(i).positionY() - 1;
        }return listOfAllAnimals;
    }
}


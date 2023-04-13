//package com.island;
//
//import com.island.BaseEntity.BaseEntity;
//import com.island.frame.Direction;
//
//import java.util.*;
//
//import static com.island.AnimalTypeEnum.*;
//import static com.island.AnimalTypeEnum.MOUSE;
//import static com.island.Constants.HEIGHT;
//import static com.island.Constants.WIDTH;
//import static com.island.frame.Direction.*;
//import static com.island.frame.StartPosition.field;
//
//
//public class BehaviorAnimals {
//    private Direction direction = Direction.LEFT;
//
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
//
//    public static Direction setRandomMove() {
//        int randomBehavior = (int) (Math.random() * 4) + 1;
//        Direction key = null;
//        if (randomBehavior == 1)
//            key = LEFT;
//        else if (randomBehavior == 2)
//            key = RIGHT;
//        else if (randomBehavior == 3)
//            key = UP;
//        else if (randomBehavior == 4)
//            key = DOWN;
//        return key;
//    }
//
////    public static BaseEntity setMove(BaseEntity baseEntity) {
////
////        if (setRandomMove().equals(LEFT))
////            startAnimals()
////        else if (setRandomMove().equals(RIGHT))
////            listOfAllAnimals.setX(x) = listOfAllAnimals.getX() + listOfAllAnimals.getMovement();
////        else if (setRandomMove().equals(UP))
////            listOfAllAnimals.setY(y) = listOfAllAnimals.getY() + listOfAllAnimals.getMovement();
////        else if (setRandomMove().equals(DOWN))
////            listOfAllAnimals.setY(y) = listOfAllAnimals.getY() - listOfAllAnimals.getMovement();
////
////        return listOfAllAnimals;
////    }
//}
//

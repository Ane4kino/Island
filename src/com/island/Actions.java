package com.island;

public class Actions {

    public interface Movable  {
        int getMovementRange();
    }

    public interface PositionAnimals {
        int positionX();

        int positionY();
    }

    public interface AnimalType {
        AnimalTypeEnum getType();
    }

    public interface Eating {
        public void eat();
    }

    public interface Reproduce {
        int getReproduce();
    }

    public interface Die {
        public void die();

    }

}
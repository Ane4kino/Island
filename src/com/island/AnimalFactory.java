package com.island;

import com.island.animals.*;
import static com.island.Constants.*;



public class AnimalFactory {
    public Animals createAnimal(AnimalTypeEnum type) {
        Animals animal = null;
        switch (type) {
            case FOX:
                animal = new Fox(WEIGHT_FOX, MAX_NUMBER_FOX, SPEED_FOX, ATE_FOX);
                break;
            case WOLF:
                animal = new Wolf(WEIGHT_WOLF, MAX_NUMBER_WOLF, SPEED_WOLF, ATE_WOLF);
                break;
            case HORSE:
                animal = new Horse(WEIGHT_HORSE, MAX_NUMBER_HORSE, SPEED_HORSE, ATE_HORSE);
                break;
            case MOUSE:
                animal = new Mouse(WEIGHT_MOUSE, MAX_NUMBER_MOUSE, SPEED_MOUSE, ATE_MOUSE);
                break;
        }
        return animal;
    }

}

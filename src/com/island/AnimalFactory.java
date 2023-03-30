package com.island;

import com.island.animals.*;

import static com.island.Constants.*;
import static com.island.frame.StartPosition.field;
import static com.island.frame.StartPosition.randomStart;


public class AnimalFactory {
    public Animals createAnimal(AnimalTypeEnum type) {
        Animals animal = null;
        switch (type) {
            case FOX:
                for (int i = 0; i < AMT_FOX_CUB; i++) {
                    int x = randomStart.nextInt(WIDTH);
                    int y = randomStart.nextInt(HEIGHT);
                    animal = new Fox(x, y);
                    field[x][y] = animal.getSymbol();

                }
                break;
            case WOLF:
                for (int i = 0; i < AMT_WOLF_CUB; i++) {
                    int x = randomStart.nextInt(WIDTH);
                    int y = randomStart.nextInt(HEIGHT);
                    animal = new Wolf(x, y);
                    field[x][y] = animal.getSymbol();
                }
                break;
            case HORSE:
                for (int i = 0; i < AMT_HORSE_CUB; i++) {
                    int x = randomStart.nextInt(WIDTH);
                    int y = randomStart.nextInt(HEIGHT);
                    animal = new Horse(x, y);
                    field[x][y] = animal.getSymbol();
                }
                break;
            case MOUSE:
                for (int i = 0; i < AMT_MOUSE_CUB; i++) {
                    int x = randomStart.nextInt(WIDTH);
                    int y = randomStart.nextInt(HEIGHT);
                    animal = new Mouse(x, y);
                    field[x][y] = animal.getSymbol();
                }
                break;
        }
        return animal;
    }

}

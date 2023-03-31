package com.island.frame;

import com.island.AnimalTypeEnum;
import com.island.Animals;
import com.island.Constants;
import com.island.animals.Fox;

import java.util.Random;

import static com.island.AnimalFactory.createAnimal;
import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class StartPosition {
    public static String[][] field = new String[Constants.WIDTH][Constants.HEIGHT];
    public static Random randomStart = new Random();

    public static void startField() {
        for (int i = 0; i < Constants.WIDTH; i++) {
            for (int j = 0; j < Constants.HEIGHT; j++) {
                field[i][j] = ".";
            }
        }
    }

    public static void startAnimals() {
        for (int i = 0; i < AMT_HORSE_CUB; i++) {
            createAnimal(HORSE);
        }
        for (int i = 0; i < AMT_FOX_CUB; i++) {
            createAnimal(FOX);
        }
        for (int i = 0; i < AMT_WOLF_CUB; i++) {
            createAnimal(WOLF);
        }
        for (int i = 0; i < AMT_MOUSE_CUB; i++) {
            createAnimal(MOUSE);
        }

    }

    public static void printRow(String[] field) {
        for (String i : field) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

//    public void doMove(Animals listOfAllAnimals) {
//        listOfAllAnimals.getMovement();
//    }
}
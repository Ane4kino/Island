package com.island.frame;

import com.island.*;

import java.util.Random;

import static com.island.BehaviorAnimals.createAnimals;
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

    public static String[][] startPosition(Animals listOfAllAnimals) {
        for (int k = 0; k < listOfAllAnimals.getReproduce(); k++) {
            getPosition(listOfAllAnimals);
        }
        return field;
    }

    public static String[][] getPosition(Animals listOfAllAnimals) {
        field[listOfAllAnimals.positionX()][listOfAllAnimals.positionY()] = listOfAllAnimals.getSymbol();
        return field;
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
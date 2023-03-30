package com.island.frame;

import com.island.Animals;
import com.island.Constants;

import java.util.Random;

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
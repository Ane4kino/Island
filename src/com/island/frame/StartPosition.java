package com.island.frame;

import com.island.*;

import java.util.Random;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;


public class StartPosition {
    public static String[][] field = new String[WIDTH][Constants.HEIGHT];
    public static Random randomStart = new Random();

    public static void startField() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
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
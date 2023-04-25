package com.island;

import java.util.Random;


public class Constants {
    public static final int[][] ISLAND_SIZE = new int[100][20];

    public static final int WIDTH = 3;
    public static final int HEIGHT = 3;
    public static final int WEIGHT_WOLF = 50;
    public static final int MAX_NUMBER_WOLF = 30;
    public static final int SPEED_WOLF = 3;
    public static final int ATE_WOLF = 3;

    public static final int WEIGHT_FOX = 15;
    public static final int MAX_NUMBER_FOX = 30;
    public static final int SPEED_FOX = 1;
    public static final int ATE_FOX = 3;

    public static final int WEIGHT_HORSE = 400;
    public static final int MAX_NUMBER_HORSE = 20;
    public static final int SPEED_HORSE = 4;
    public static final int ATE_HORSE = 60;

    public static final int WEIGHT_MOUSE = 400;
    public static final int MAX_NUMBER_MOUSE = 20;
    public static final int SPEED_MOUSE = 4;
    public static final int ATE_MOUSE = 60;
    public static final int AMT_FOX_CUB = (int) (Math.random() * 12) + 5;
    public static final int AMT_WOLF_CUB = (int) (Math.random() * 8) + 4;
    public static final int AMT_HORSE_CUB = (int) (Math.random() * 2) + 1;
    public static final int AMT_MOUSE_CUB = (int) (Math.random() * 12) + 5;
    private static final Random random = new Random();

    // Генерируем случайное число в диапазоне от min (включительно) до max (исключительно)
    public static int getRandomNumber(int min, int max) {
        return random.nextInt(max - min) + min;
    }

}

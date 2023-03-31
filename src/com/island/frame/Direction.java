package com.island.frame;

public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int xOffset;
    private final int yOffset;

    Direction(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getYOffset() {
        return yOffset;
    }

    public static Direction getRandomDirection() {
        Direction[] directions = Direction.values();
        int randomIndex = (int) (Math.random() * directions.length);
        return directions[randomIndex];
    }
}


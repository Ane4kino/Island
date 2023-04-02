package com.island;

import java.util.ArrayList;
import java.util.List;

public class AnimalPosition {
    private int x;
    private int y;
    private List<Animals> animals;

    public AnimalPosition(int x, int y) {
        this.x = x;
        this.y = y;
        this.animals = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Animals> getAnimals() {
        return animals;
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animals animal) {
        animals.remove(animal);
    }

    public boolean isEmpty() {
        return animals.isEmpty();
    }

    public boolean hasAnimals() {
        return !isEmpty();
    }

    public int getAnimalCount() {
        return animals.size();
    }
}

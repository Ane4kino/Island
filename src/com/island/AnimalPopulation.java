package com.island;

import com.island.Animals;
import com.island.animals.Fox;
import com.island.animals.Horse;
import com.island.animals.Mouse;
import com.island.animals.Wolf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.island.Constants.*;
import static com.island.frame.StartPosition.field;

public class AnimalPopulation {
    private final List<Animals> animals;

    private AnimalGrid animalGrid;

    public AnimalPopulation() {
        this.animals = new ArrayList<>();
    }
    public AnimalGrid getAnimalGrid() {
        return animalGrid;
    }

    public void addAnimal(Animals animal) {
        animals.add(animal);
    }

    public int getCount(AnimalTypeEnum animalType) {
        int count = 0;
        for (Animals animal : animals) {
            if (animal.getType().equals(animalType.toString())) {
                count++;
            }
        }
        return count;
    }

    public List<Animals> getAnimals() {
        return animals;
    }

//    public void removeDeadAnimals() {
//        animals.removeIf(animal -> !animal.isAlive());
//    }

    public static void startAnimals(AnimalPopulation population) {
        Random randomStart = new Random();
        int x, y;

        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Horse horse1 = new Horse(5, true, new AnimalPosition(x, y));
        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Horse horse2 = new Horse(0, true, new AnimalPosition(x, y));
        population.addAnimal(horse1);
        population.addAnimal(horse2);

        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Fox fox1 = new Fox(0, true, new AnimalPosition(x, y));
        population.addAnimal(fox1);

        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Mouse mouse1 = new Mouse(0, true, new AnimalPosition(x, y));
        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Mouse mouse2 = new Mouse(0, true, new AnimalPosition(x, y));
        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Mouse mouse3 = new Mouse(0, true, new AnimalPosition(x, y));
        population.addAnimal(mouse1);
        population.addAnimal(mouse2);
        population.addAnimal(mouse3);

        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Wolf wolf1 = new Wolf(0, true, new AnimalPosition(x, y));
        x = randomStart.nextInt(WIDTH);
        y = randomStart.nextInt(HEIGHT);
        Wolf wolf2 = new Wolf(0, true, new AnimalPosition(x, y));
        population.addAnimal(wolf1);
        population.addAnimal(wolf2);
    }

    public void printAnimalMap() {
        for (Animals animal : animals) {
            int x = animal.getPosition().getX();
            int y = animal.getPosition().getY();
            field[x][y] = animal.getSymbol();
        }
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                System.out.print(field[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

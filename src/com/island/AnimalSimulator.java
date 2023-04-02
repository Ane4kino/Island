package com.island;

import java.util.*;

import static com.island.Constants.*;

public class AnimalSimulator {
    private List<Animals> animals;
    private AnimalGrid animalGrid;

    public AnimalSimulator(AnimalPopulation population) {
        animalGrid = population.getAnimalGrid();
        animals = population.getAnimals();
    }

    public void startSimulation(int rounds, int delaySeconds) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Животные после " + i + " лет жизни:");
            Iterator<AnimalPosition> iterator = animalGrid.getAnimalPositionListMap().keySet().iterator();
            while (iterator.hasNext()) {
                AnimalPosition position = iterator.next();
                List<Animals> animals = animalGrid.getAnimalPositionListMap().get(position);
                if (animals != null && !animals.isEmpty()) {
                    List<Animals> animalsCopy = new ArrayList<>(animals);
                    for (Animals animal : animalsCopy) {
                        position.removeAnimal(animal);
                        List<AnimalPosition> newPositions = animal.move(position, animalGrid);
                        for (AnimalPosition newPosition : newPositions) {
                            animalGrid.addAnimal(animal, newPosition);
                        }
                    }
                }
            }
            try {
                Thread.sleep(delaySeconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
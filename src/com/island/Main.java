package com.island;

import com.island.BaseEntity.BaseEntity;

import static com.island.AnimalMovement.*;
import static com.island.BaseEntityPopulation.startAnimals;


public class Main {
    public static void main(String[] args) {

        BaseEntityPopulation population = new BaseEntityPopulation();
        startAnimals(population);

        AnimalGrid animalGrid = new AnimalGrid(population, population.getBaseEntity());
        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);

        animalGrid.move();

        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);


    }
}

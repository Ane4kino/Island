package com.island;

import static com.island.AnimalMovement.*;
import static com.island.BaseEntityPopulation.startAnimals;



public class Main {
    public static void main(String[] args) {

        BaseEntityPopulation population = new BaseEntityPopulation();
        startAnimals(population);
//        population.printAnimalMap();

        AnimalGrid animalGrid = new AnimalGrid(population, population.getBaseEntity());
        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);

        moveAnimals(population.getBaseEntity());

        animalGrid.printAllGrid(population);


//        animalGrid.moveAnimals();
//        animalGrid.printGrid();

        //      AnimalSimulator simulator = new AnimalSimulator(animalGrid, population);
//        simulator.startSimulation(1,1,population);
//        population.printAnimalCount();
        //    population.printAnimalMap();


//        for (String[] row : field) {
//            printRow(row);
//        }


    }
}

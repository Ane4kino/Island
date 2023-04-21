package com.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.Predators.Wolf;
import com.island.frame.AnimalGrid;

import java.io.IOException;

//import static com.island.BaseEntityPopulation.startAnimals;


public class Main {
    public static void main(String[] args) throws IOException {

        BaseEntityPopulation population = new BaseEntityPopulation();
        AnimalFactory animalFactory = new AnimalFactory(new ObjectMapper(), population);
        population.startAnimals(animalFactory, population);
        AnimalGrid animalGrid = new AnimalGrid(population);


        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);
        animalGrid.move(population);


        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);
        animalGrid.move(population);
        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);

    }
}

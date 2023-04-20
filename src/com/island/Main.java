package com.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.Predators.Wolf;
import com.island.frame.AnimalGrid;
import com.island.frame.Cell;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//import static com.island.BaseEntityPopulation.deserializeAnimals;
import static com.island.BaseEntityPopulation.startAnimals;


public class Main {
    public static void main(String[] args) throws IOException {

        BaseEntityPopulation population = new BaseEntityPopulation();
        startAnimals(population);

       Wolf wolf =new Wolf("src/com/island/file/wolf.json");
        System.out.println(wolf);

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

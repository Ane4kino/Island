package com.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Predators.Wolf;
import com.island.frame.AnimalGrid;
import com.island.frame.Cell;

import java.io.IOException;

import static com.island.Constants.WIDTH;
import static java.awt.image.ImageObserver.HEIGHT;

//import static com.island.BaseEntityPopulation.startAnimals;


public class Main {
    public static void main(String[] args) throws IOException {

        BaseEntityPopulation population = new BaseEntityPopulation();
        AnimalFactory animalFactory = new AnimalFactory(new ObjectMapper(), population);
        Cell cell = new Cell(population);
        AnimalGrid animalGrid = new AnimalGrid(population, animalFactory);
        animalGrid.startGrid(animalFactory, cell);
//        population.startAnimals(animalFactory);
//        animalGrid.startGrid(animalFactory,population);
//        animalGrid.populate(population);
//        animalGrid.setTable(table);


        animalGrid.printGrid(population);
        animalGrid.printAllGrid(population);
//        animalGrid.move(population,table);
//
//
//        animalGrid.printGrid(population);
//        animalGrid.printAllGrid(population);
//        animalGrid.move(population,table);
//        animalGrid.printGrid(population);
//        animalGrid.printAllGrid(population);

    }
}

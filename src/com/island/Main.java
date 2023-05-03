package com.island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.frame.AnimalGrid;
import com.island.frame.Cell;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

        BaseEntityPopulation population = new BaseEntityPopulation();
        AnimalFactory animalFactory = new AnimalFactory(new ObjectMapper(), population);
        AnimalGrid animalGrid = new AnimalGrid(population);
        animalGrid.populateTable(animalFactory, population);
        Cell[][] table = animalGrid.getTable();
        Actions actions = new Actions(table);

        Runner runner = new Runner(actions, animalFactory, table, population, animalGrid);
        runner.start();

    }
//


//        BaseEntityPopulation population = new BaseEntityPopulation();
//        AnimalFactory animalFactory = new AnimalFactory(new ObjectMapper(), population);
//
//        AnimalGrid animalGrid = new AnimalGrid(population);
//        Cell[][] table = animalGrid.getTable();
//        animalGrid.populateTable(animalFactory, population);
//
//
////        animalGrid.printAllGrid(population);
//        Actions actions = new Actions(table);
//        System.out.println("Первый запуск животных");
//        animalGrid.printGrid(population);
//        System.out.println();
//        System.out.println("*********************");
//        for (int i = 0; i < 20; i++) {
//            actions.move(table, population);
//
//            actions.performBreeding(animalFactory, population);
//            actions.runningTime(population);
//            actions.eating(population);
//            animalGrid.printGrid(population);
//            System.out.println();
//            System.out.println("*********************");
////            animalGrid.printAllGrid(population); //будет выводить в консоль в виде таблицы
//
////            animalGrid.printGrid(population);
////            animalGrid.printAllGrid(population);
//
//        }
//    }
}


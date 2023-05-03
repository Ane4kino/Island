package com.island;

import com.island.frame.AnimalGrid;
import com.island.frame.Cell;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner extends Thread {
    private Actions actions;
    private BaseEntityPopulation population;
    private AnimalFactory animalFactory;
    private Cell[][] table;
    private AnimalGrid animalGrid;

    public Runner(Actions actions, AnimalFactory animalFactory, Cell[][] table, BaseEntityPopulation population, AnimalGrid animalGrid) throws IOException {
        this.actions = actions;
        this.animalFactory = animalFactory;
        this.table = table;
        this.population = population;
        this.animalGrid = animalGrid;
    }

    @Override
    public void run() {

        System.out.println("Первый запуск животных");
        animalGrid.printGrid(population);
        System.out.println();
        System.out.println("*********************");

        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            actions.move(table, population);
            actions.eating(population);
            try {
                actions.performBreeding(animalFactory, population);
            } catch (IOException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            actions.runningTime(population);
            animalGrid.printGrid(population);
            System.out.println();
            System.out.println("*********************");
        }
        service.shutdown();
    }
}

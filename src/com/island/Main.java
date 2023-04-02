package com.island;

import com.island.animals.Fox;
import com.island.animals.Horse;
import com.island.animals.Mouse;
import com.island.animals.Wolf;

import java.util.*;

import static com.island.AnimalPopulation.startAnimals;
import static com.island.Constants.*;
import static com.island.frame.StartPosition.*;

import com.island.AnimalPopulation.*;


public class Main {
    public static void main(String[] args) {

        startField();
        AnimalPopulation population = new AnimalPopulation();
        startAnimals(population);
        population.printAnimalMap();

        AnimalGrid animalGrid = new AnimalGrid(population);
        AnimalSimulator simulator = new AnimalSimulator(population);
        simulator.startSimulation(10, 1);
        population.printAnimalMap();


//        for (String[] row : field) {
//            printRow(row);
//        }


    }
}

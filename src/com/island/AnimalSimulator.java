package com.island;

import com.island.BaseEntity.BaseEntity;

import java.util.*;

public class AnimalSimulator {
    private List<BaseEntity> baseEntities;
    private int animalX;
    private int animalY;

    public AnimalSimulator(AnimalGrid animalGrid, BaseEntityPopulation population) {

    }

    public AnimalSimulator(BaseEntityPopulation population, AnimalPosition animalGrid) {
        animalX = animalGrid.getX();
        animalY = animalGrid.getY();
        baseEntities = population.getBaseEntity();
    }


//    public void startSimulation(int years, int delaySeconds, AnimalPopulation population, AnimalPosition animalGrid) {
//        for (int i = 0; i < years; i++) {
//            for (AnimalPopulation animalPopulation: population.) {
//
//            }
//            try {
//                Thread.sleep(delaySeconds * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}

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

}

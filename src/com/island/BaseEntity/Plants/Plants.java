package com.island.BaseEntity.Plants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Predators.Wolf;
import com.island.BaseEntityPopulation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Plants extends BaseEntity {
    private Map<String, Integer> eatingMap;

    public Map<String, Integer> getEatingMap() {
        return eatingMap;

    }
    public Plants() {
    }
    public Plants(String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
                 int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
                 boolean isAlive, Map<String, Integer> eatingMap, AnimalPosition position) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,
                weight, kilogramToSaturation,true);
        this.isAlive=true;
        this.eatingMap = eatingMap;
        this.position = position;
    }

    @Override
    public int getReproduce() {
        return 0;
    }

    @Override
    public AnimalTypeEnum getType() {
        return null;
    }

    @Override
    public String getSymbol() {
        return "\uD83C\uDF31";
    }
}

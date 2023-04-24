package com.island.BaseEntity.Herbivores;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Predators.Fox;
import com.island.BaseEntityPopulation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class Mouse extends BaseEntity {
    private Map<String, Integer> eatingMap;

    public Map<String, Integer> getEatingMap() {
        eatingMap.put("Plants", 90);
        return eatingMap;

    }
    public Mouse() {
    }
    public Mouse (String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
                 int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
                 boolean isAlive, Map<String, Integer> eatingMap ) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,
                weight, kilogramToSaturation, isAlive);
        this.eatingMap = eatingMap;
//        this.position = position;
    }
    @Override
    public String getSymbol() {
        return "\uD83D\uDC01";
    }

    @Override
    public int getReproduce() {
        return AMT_MOUSE_CUB;
    }

    @Override
    public AnimalTypeEnum getType() {
        return MOUSE;
    }

    @Override
    public String getName() {
        return "Мышь(ей)";
    }

//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {

//    }


}

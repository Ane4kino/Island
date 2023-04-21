package com.island.BaseEntity.Predators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;
import com.island.frame.Cell;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.island.AnimalTypeEnum.WOLF;
import static com.island.Constants.AMT_WOLF_CUB;

public class Wolf extends BaseEntity {

    private Map<String, Integer> eatingMap;

    public Map<String, Integer> getEatingMap() {
//        eatingMap=new HashMap<>();
        eatingMap.put("Rabbit", 60);
        eatingMap.put("Mouse", 80);
        eatingMap.put("Deer", 15);
        eatingMap.put("Horse", 10);
        eatingMap.put("Goat", 60);
        eatingMap.put("Sheep", 70);
        return eatingMap;
    }

    @Override
    public AnimalPosition getPosition() {
        return position;
    }

    protected AnimalPosition position;

    public void setEatingMap(Map<String, Integer> eatingMap) {
        this.eatingMap = eatingMap;
    }

    public void setPosition(AnimalPosition position) {
        this.position = position;
    }

    public Wolf(String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
                int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
                boolean isAlive, Map<String, Integer> eatingMap, AnimalPosition position) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,
                weight, kilogramToSaturation,true);
        this.isAlive=true;
        this.eatingMap = eatingMap;
        this.position = position;

    }
    public Wolf() {
    }

    @Override
    public String getSymbol() {
        return "\uD83D\uDC3A";
    }

    @Override
    public int getReproduce() {
        return AMT_WOLF_CUB;
    }

    @Override
    public AnimalTypeEnum getType() {
        return WOLF;
    }

    @Override
    public String getName() {
        return "волк(ов)";
    }


//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }

}

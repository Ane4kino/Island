package com.island.BaseEntity.Predators;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Herbivores.Horse;
import com.island.BaseEntityPopulation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.island.AnimalTypeEnum.FOX;
import static com.island.Constants.*;

public class Fox extends BaseEntity {
    private Map<String, Integer> eatingMap;

    public Map<String, Integer> getEatingMap() {
//        eatingMap=new HashMap<>();
        eatingMap.put("Rabbit", 70);
        eatingMap.put("Mouse", 90);
        return eatingMap;
    }
    public Fox() {
    }

    public Fox(String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
               int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
               boolean isAlive, Map<String, Integer> eatingMap, AnimalPosition position) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,
                weight, kilogramToSaturation,true);
        this.isAlive=true;
        this.eatingMap = eatingMap;
        this.position = position;
    }

    @Override
    public String getSymbol() {
        return "\uD83E\uDD8A";
    }

    @Override
    public int getReproduce() {
        return AMT_FOX_CUB;
    }

    @Override
    public AnimalTypeEnum getType() {
        return FOX;
    }

    @Override
    public String getName() {
        return "лис(а)";
    }

    @Override
    public String toString() {
        return "Fox{}" + super.toString();
    }
}

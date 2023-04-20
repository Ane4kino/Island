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
    private String name;
    private String icon;
    private int age;
    private int maxAge;
    private int movementRange;//диапазон движения
    private int breedingAge;//возраст размножения
    private int maxNumber;//максимальное количество на ячейке
    private double breedingProbability;//вероятность размножения
    private double weight;
    private double kilogramToSaturation;// максимальное значение насыщения
    private Map<BaseEntityPopulation, Integer> eatingMap;
    public Fox( boolean isAlive, AnimalPosition position, ObjectMapper objectMapper, String filePath) throws IOException {
        super(isAlive, position);
        Fox fox = objectMapper.readValue(new File(filePath), Fox.class);
        this.name = fox.name;
        this.icon = fox.icon;
        this.age = fox.age;
        this.maxAge = fox.maxAge;
        this.movementRange = fox.movementRange;
        this.breedingAge = fox.breedingAge;
        this.maxNumber = fox.maxNumber;
        this.breedingProbability = fox.breedingProbability;
        this.weight = fox.weight;
        this.kilogramToSaturation = fox.kilogramToSaturation;
        this.objectMapper = objectMapper;
        this.eatingMap = fox.eatingMap;
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
        return "Fox{}"+super.toString();
    }
}

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
    public Plants( boolean isAlive, AnimalPosition position, ObjectMapper objectMapper, String filePath) throws IOException {
        super(isAlive, position);
        Plants plants = objectMapper.readValue(new File(filePath), Plants.class);
        this.name = plants.name;
        this.icon = plants.icon;
        this.age = plants.age;
        this.maxAge = plants.maxAge;
        this.movementRange = plants.movementRange;
        this.breedingAge = plants.breedingAge;
        this.maxNumber = plants.maxNumber;
        this.breedingProbability = plants.breedingProbability;
        this.weight = plants.weight;
        this.kilogramToSaturation = plants.kilogramToSaturation;
        this.objectMapper = objectMapper;
        this.eatingMap = plants.eatingMap;
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

package com.island.BaseEntity.Herbivores;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.*;
import com.island.BaseEntityPopulation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.island.AnimalTypeEnum.*;
import static com.island.Constants.*;

public class Horse extends BaseEntity {
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
    private ObjectMapper objectMapper;
    private Map<BaseEntityPopulation, Integer> eatingMap;

    public Horse( boolean isAlive, AnimalPosition position, ObjectMapper objectMapper, String filePath) throws IOException {
        super(isAlive, position);
        Horse horse = objectMapper.readValue(new File(filePath), Horse.class);
        this.name = horse.name;
        this.icon = horse.icon;
        this.age = horse.age;
        this.maxAge = horse.maxAge;
        this.movementRange = horse.movementRange;
        this.breedingAge = horse.breedingAge;
        this.maxNumber = horse.maxNumber;
        this.breedingProbability = horse.breedingProbability;
        this.weight = horse.weight;
        this.kilogramToSaturation = horse.kilogramToSaturation;
        this.objectMapper = objectMapper;
        this.eatingMap = horse.eatingMap;
    }


    @Override
    public String getSymbol() {
        return "\uD83D\uDC0E";
    }

    @Override
    public int getReproduce() {
        return AMT_HORSE_CUB;
    }

    @Override
    public AnimalTypeEnum getType() {
        return HORSE;
    }

    @Override
    public String getName() {
        return "лошадь(ей)";
    }

//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }
}

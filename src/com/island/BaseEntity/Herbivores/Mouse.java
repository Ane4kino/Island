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
    public Mouse( boolean isAlive, AnimalPosition position, ObjectMapper objectMapper,  String filePath) throws IOException {
        super(isAlive, position);
        Mouse mouse = objectMapper.readValue(new File(filePath), Mouse.class);
        this.name = mouse.name;
        this.icon = mouse.icon;
        this.age = mouse.age;
        this.maxAge = mouse.maxAge;
        this.movementRange = mouse.movementRange;
        this.breedingAge = mouse.breedingAge;
        this.maxNumber = mouse.maxNumber;
        this.breedingProbability = mouse.breedingProbability;
        this.weight = mouse.weight;
        this.kilogramToSaturation = mouse.kilogramToSaturation;
        this.objectMapper = objectMapper;
        this.eatingMap = mouse.eatingMap;
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

package com.island.BaseEntity.Herbivores;

import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;

import java.util.Map;

import static com.island.AnimalTypeEnum.HORSE;
import static com.island.Constants.AMT_HORSE_CUB;

public class Horse extends BaseEntity {
    private Map<String, Integer> eatingMap;

    public Map<String, Integer> getEatingMap() {
        eatingMap.put("Plants", 90);
        return eatingMap;

    }
    public Horse() {
    }
    public Horse(String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
                 int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
                 boolean isAlive, Map<String, Integer> eatingMap) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,weight, kilogramToSaturation,true);
//        this.isAlive=true;
        this.eatingMap = eatingMap;
//        this.position = position;
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

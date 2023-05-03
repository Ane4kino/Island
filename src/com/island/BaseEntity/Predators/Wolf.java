package com.island.BaseEntity.Predators;

import com.island.BaseEntity.BaseEntity;

import java.util.Map;

public class Wolf extends BaseEntity {

//    private Map<String, Integer> eatingMap;
//
//    public Map<String, Integer> getEatingMap() {
//        eatingMap.put("\uD83D\uDC07", 60);//Rabbit
//        eatingMap.put("\uD83D\uDC01", 80);//Mouse
//        eatingMap.put("\uD83E\uDD8C", 15);//Deer
//        eatingMap.put("\uD83D\uDC34", 10);//Horse
//        eatingMap.put("\uD83D\uDC10", 60);//Goat
//        eatingMap.put("\uD83D\uDC11", 70);//Sheep
//        return eatingMap;
//    }

    public Wolf(String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
                int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
                boolean isAlive, Map<String, Integer> eatingMap,int energyLevel) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,
                weight, kilogramToSaturation,true,eatingMap, energyLevel);
    }
    public Wolf() {
    }
}

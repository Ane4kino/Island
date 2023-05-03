package com.island.BaseEntity.Plants;
import com.island.BaseEntity.BaseEntity;

import java.util.Map;

public class Plants extends BaseEntity {

    public Plants() {
    }

    public Plants(String name, String icon, int age, int maxAge, int movementRange, int breedingAge,
                  int maxNumber, double breedingProbability, double weight, double kilogramToSaturation,
                  boolean isAlive, Map<String, Integer> eatingMap, int energyLevel) {
        super(name, icon, age, maxAge, movementRange, breedingAge, maxNumber, breedingProbability,
                weight, kilogramToSaturation, true, eatingMap, energyLevel);

    }

}

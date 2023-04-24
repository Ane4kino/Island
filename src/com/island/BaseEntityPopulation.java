package com.island;

import com.island.BaseEntity.BaseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BaseEntityPopulation {

    private List<BaseEntity> baseEntities;

    private List<BaseEntity> baseEntitiesToCell;

    public void setBaseEntitiesToCell(List<BaseEntity> baseEntitiesToCell) {
        this.baseEntitiesToCell = baseEntitiesToCell;
    }

    public List<BaseEntity> getBaseEntitiesToCell() {
        return baseEntitiesToCell;
    }


    public BaseEntityPopulation(List<BaseEntity> baseEntities, List<BaseEntity> baseEntitiesToCell) {
        this.baseEntities = new ArrayList<>();
        this.baseEntitiesToCell = baseEntitiesToCell;
    }


    public BaseEntityPopulation() {
        this.baseEntities = new ArrayList<>();
    }

    public void addAnimal(BaseEntity baseEntity) {
        baseEntities.add(baseEntity);
    }

    public int getCount(AnimalTypeEnum animalType) {
        int count = 0;
        for (BaseEntity baseEntity : baseEntities) {
            if (baseEntity.getType().equals(animalType.toString())) {
                count++;
            }
        }
        return count;
    }

    public List<BaseEntity> getBaseEntity() {
        return baseEntities;
    }

    public void setBaseEntity(List<BaseEntity> baseEntities) {
        this.baseEntities = baseEntities;
    }


    private Map<String, Integer> eatingMap;

    public List<String> getEntityNameList() {
        List<String> entityNameList = new ArrayList<>();
//        entityNameList.add("Rabbit");
        entityNameList.add("Mouse");
//        entityNameList.add("Deer");
        entityNameList.add("Fox");
        entityNameList.add("Plants");
        entityNameList.add("Wolf");
        entityNameList.add("Horse");
//        entityNameList.add("Goat");
//        entityNameList.add("Sheep");
        return entityNameList;
    }


    public List<String> getAllSymbols() {
        List<String> symbols = new ArrayList<>();
        for (BaseEntity animal : getBaseEntity()) {
            String symbol = animal.getSymbol();
            if (!symbols.contains(symbol)) {
                symbols.add(symbol);
            }
        }
        return symbols;
    }

}

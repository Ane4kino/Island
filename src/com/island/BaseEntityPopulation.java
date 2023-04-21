package com.island;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Herbivores.Horse;
import com.island.BaseEntity.Herbivores.Mouse;
import com.island.BaseEntity.Plants.Plants;
import com.island.BaseEntity.Predators.Fox;
import com.island.BaseEntity.Predators.Wolf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;


public class BaseEntityPopulation {

    private final List<BaseEntity> baseEntities;

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

    public void startAnimals(AnimalFactory animalFactory, BaseEntityPopulation population) throws IOException {

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                AnimalPosition position = new AnimalPosition(x, y);
                int n = (int) (Math.random() * 2) + 1;
                animalFactory.createAnimals(n, "Horse", position);
                n = (int) (Math.random() * 4) + 1;
                animalFactory.createAnimals(n, "Mouse", position);
                n = (int) (Math.random() * 4) + 1;
                animalFactory.createAnimals(n, "Fox", position);
                n = (int) (Math.random() * 4) + 1;
                animalFactory.createAnimals(n, "Wolf", position);
                n = (int) (Math.random() * 4) + 1;
                animalFactory.createAnimals(n, "Plants", position);

            }
        }
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

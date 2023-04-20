package com.island;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Herbivores.Horse;
import com.island.BaseEntity.Herbivores.Mouse;
import com.island.BaseEntity.Plants.Plants;
import com.island.BaseEntity.Predators.Fox;
import com.island.BaseEntity.Predators.Wolf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static void startAnimals(BaseEntityPopulation population) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        for (BaseEntity entity : population.getBaseEntity()) {
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    int n = (int) (Math.random() * 4);
                    for (int k = 0; k < n; k++) {
                        Horse horse = new Horse(true, new AnimalPosition(x, y), objectMapper,"src/com/island/file/horse.json");
                        population.addAnimal(horse);
                    }
                    n = (int) (Math.random() * 4);
                    for (int k = 0; k < n; k++) {
                        Fox fox = new Fox(true, new AnimalPosition(x, y),objectMapper,"src/com/island/file/fox.json");
                        population.addAnimal(fox);
                    }
                    n = (int) (Math.random() * 4);
                    for (int k = 0; k < n; k++) {
                        Mouse mouse = new Mouse(true, new AnimalPosition(x, y),objectMapper,"src/com/island/file/mouse.json");
                        population.addAnimal(mouse);
                    }
                    n = (int) (Math.random() * 4);
                    for (int k = 0; k < n; k++) {
                        Wolf wolf = new Wolf("src/com/island/file/wolf.json");
                        population.addAnimal(wolf);
                    }
                    n = (int) (Math.random() * 8);
                    for (int k = 0; k < n; k++) {
                        Plants plants = new Plants(true, new AnimalPosition(x, y),objectMapper,"src/com/island/file/plants.json");
                        population.addAnimal(plants);
                    }
                }
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

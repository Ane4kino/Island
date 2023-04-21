package com.island;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.Herbivores.Horse;
import com.island.BaseEntity.Herbivores.Mouse;
import com.island.BaseEntity.Plants.Plants;
import com.island.BaseEntity.Predators.Fox;
import com.island.BaseEntity.Predators.Wolf;

import java.io.File;
import java.io.IOException;

public class AnimalFactory {
    private final ObjectMapper objectMapper;
    private final BaseEntityPopulation  population;

    public AnimalFactory(ObjectMapper objectMapper, BaseEntityPopulation population) {
        this.objectMapper = objectMapper;
        this.population = population;
    }

    public void createAnimals(int count, String type, AnimalPosition position) throws IOException {
        for (int i = 0; i < count; i++) {
            switch (type) {
                case "Horse":
                    Horse horse = objectMapper.readValue(new File("src/com/island/file/horse.json"), Horse.class);
//                    horse.setPosition(x, y);
                    horse.setIsAlive(true);
                    population.addAnimal(horse);
                    break;
                case "Wolf":
                    Wolf wolf = objectMapper.readValue(new File("src/com/island/file/wolf.json"), Wolf.class);
//                    wolf.setPosition(x, y);
                    wolf.setIsAlive(true);
                    population.addAnimal(wolf);
                    break;
                case "Fox":
                    Fox fox = objectMapper.readValue(new File("src/com/island/file/fox.json"), Fox.class);
//                    fox.setPosition(x, y);
                    fox.setIsAlive(true);
                    population.addAnimal(fox);
                    break;
                case "Mouse":
                    Mouse mouse = objectMapper.readValue(new File("src/com/island/file/mouse.json"), Mouse.class);
//                    mouse.setPosition(x, y);
                    mouse.setIsAlive(true);
                    population.addAnimal(mouse);
                    break;
                case "Plants":
                    Plants plants = objectMapper.readValue(new File("src/com/island/file/plants.json"), Plants.class);
//                    plants.setPosition(x, y);
                    plants.setIsAlive(true);
                    population.addAnimal(plants);
                    break;
                default:
                    throw new IllegalArgumentException("Недопустимый тип животного: " + type);
            }
        }
    }
}


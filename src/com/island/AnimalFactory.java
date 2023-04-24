package com.island;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.BaseEntity.Herbivores.Horse;
import com.island.BaseEntity.Herbivores.Mouse;
import com.island.BaseEntity.Plants.Plants;
import com.island.BaseEntity.Predators.Fox;
import com.island.BaseEntity.Predators.Wolf;
import com.island.frame.Cell;

import java.io.File;
import java.io.IOException;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;

public class AnimalFactory {
    private final ObjectMapper objectMapper;
    private final BaseEntityPopulation  population;

    public AnimalFactory(ObjectMapper objectMapper, BaseEntityPopulation population) {
        this.objectMapper = objectMapper;
        this.population = population;
    }

    public BaseEntityPopulation createAnimals(int count, String type) throws IOException {

                for (int i = 0; i < count; i++) {

                    switch (type) {
                        case "Horse":
                            Horse horse = objectMapper.readValue(new File("src/com/island/file/horse.json"), Horse.class);
                            horse.setIsAlive(true);
                            population.addAnimal(horse);
                            break;
                        case "Wolf":
                            Wolf wolf = objectMapper.readValue(new File("src/com/island/file/wolf.json"), Wolf.class);
                            wolf.setIsAlive(true);
                            population.addAnimal(wolf);
                            break;
                        case "Fox":
                            Fox fox = objectMapper.readValue(new File("src/com/island/file/fox.json"), Fox.class);
                            fox.setIsAlive(true);
                            population.addAnimal(fox);
                            break;
                        case "Mouse":
                            Mouse mouse = objectMapper.readValue(new File("src/com/island/file/mouse.json"), Mouse.class);
                            mouse.setIsAlive(true);
                            population.addAnimal(mouse);
                            break;
                        case "Plants":
                            Plants plants = objectMapper.readValue(new File("src/com/island/file/plants.json"), Plants.class);
                            plants.setIsAlive(true);
                            population.addAnimal(plants);
                            break;
                        default:
                            throw new IllegalArgumentException("Недопустимый тип животного: " + type);
                    }
                }

        return population;
    }
}


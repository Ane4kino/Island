package com.island;

import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.*;
import com.island.BaseEntity.Herbivores.*;
import com.island.BaseEntity.Predators.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.island.Constants.*;
import static com.island.frame.StartPosition.field;

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

    public static void startAnimals(BaseEntityPopulation population) {

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                int n = (int) (Math.random() * 2);
                for (int k = 0; k < n; k++) {
                    Horse horse = new Horse(0, true, new AnimalPosition(x + k, y + k));
                    population.addAnimal(horse);
                }
                n = (int) (Math.random() * 2);
                for (int k = 0; k < n; k++) {
                    Fox fox = new Fox(0, true, new AnimalPosition(x + k, y + k));
                    population.addAnimal(fox);
                }
                n = (int) (Math.random() * 2);
                for (int k = 0; k < n; k++) {
                    Mouse mouse = new Mouse(0, true, new AnimalPosition(x + k, y + k));
                    population.addAnimal(mouse);
                }
                n = (int) (Math.random() * 2);
                for (int k = 0; k < n; k++) {
                    Wolf wolf = new Wolf(0, true, new AnimalPosition(x + k, y + k));
                    population.addAnimal(wolf);
                }
            }
        }
    }


    public void printAnimalMap() {
        for (BaseEntity baseEntity : baseEntities) {
            int positionX = baseEntity.getPosition().getX();
            int positionY = baseEntity.getPosition().getY();

            if (!baseEntities.isEmpty()) {
                String animalNames = baseEntity.getSymbol().lines().collect(Collectors.joining(","));

                field[positionX][positionY] = animalNames;
                System.out.println(positionX + "," + positionY + " " + animalNames);
            } else {
                // Если список animals пуст, то устанавливаем символ "." на поле
                field[positionX][positionY] = ".";
            }
        }
    }
}

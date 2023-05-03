package com.island;

import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntity.Herbivores.Caterpillar;
import com.island.BaseEntity.Plants.Plants;
import com.island.frame.Cell;
import com.island.frame.Direction;

import java.io.IOException;
import java.util.*;

import static com.island.frame.AnimalGrid.HEIGHT;
import static com.island.frame.AnimalGrid.WIDTH;


public class Actions {
    private Cell[][] table;

    public Actions(Cell[][] table) {
        this.table = table;
    }

    public void move(Cell[][] table, BaseEntityPopulation population) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Cell currentCell = table[x][y];
                List<BaseEntity> entities = currentCell.getEntities();
                Iterator<BaseEntity> iterator = entities.iterator();
                List<BaseEntity> toRemove = new ArrayList<>();

                while (iterator.hasNext()) {
                    BaseEntity entity = iterator.next();
                    if (entity instanceof Plants || entity instanceof Caterpillar) {
                        continue; // пропускаем растения
                    }
                    int movementRadius = entity.getMovementRange();
                    Direction randomMove = setRandomMove();
                    int newX = x + (randomMove == Direction.LEFT ? -movementRadius : randomMove == Direction.RIGHT ? movementRadius : 0);
                    int newY = y + (randomMove == Direction.UP ? -movementRadius : randomMove == Direction.DOWN ? movementRadius : 0);

                    // Проверяем, что новые координаты находятся в пределах острова
                    if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                        Cell newCell = table[newX][newY];
                        if (newCell.getAnimalCount(entity) >= entity.getMaxNumber())
                            continue;
                        newCell.addEntity(entity);
                        toRemove.add(entity);
                    }
                }
                for (BaseEntity base : toRemove) {
                    currentCell.removeEntity(base);
                }


            }
        }
    }

    public void runningTime(BaseEntityPopulation population) {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                Cell currentCell = table[x][y];
                Map<BaseEntity, Integer> countEntity = currentCell.getAnimalCounts(population);
                for (BaseEntity baseEntity : countEntity.keySet()) {

                    if (baseEntity == null) continue;
                    int newAge = baseEntity.getAge() + 1;
                    if (baseEntity.getAge() < newAge)
                        baseEntity.setAge(newAge);

                    if (baseEntity.getName().equals("Plants")) {
                        baseEntity.setEnergyLevel(baseEntity.getEnergyLevel() - 1);
                    } else {
                        int newEnergy = baseEntity.getEnergyLevel() - 20;
                        baseEntity.setEnergyLevel(newEnergy);
                    }

                }
            }
        }
    }

    public void eating(BaseEntityPopulation population) {
        Map<String, Integer> eatenAnimalsByType = new HashMap<>();
        Map<String, Integer> starvedToDeath = new HashMap<>();

        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                Cell currentCell = table[x][y];
                Map<BaseEntity, Integer> countEntity = currentCell.getAnimalCounts(population);
                for (BaseEntity baseEntity : countEntity.keySet()) {
                    if (baseEntity == null) continue;
                    if (baseEntity.getEnergyLevel() > 80) {
                        continue;
                    } else if (baseEntity.getEnergyLevel() < 20) {
                        currentCell.removeEntity(baseEntity);
                        population.removeEntity(baseEntity);
                        int countStarvedToDeath = starvedToDeath.getOrDefault(baseEntity.getIcon(), 0);
                        starvedToDeath.put(baseEntity.getIcon(), countStarvedToDeath + 1);
                    }

                    Map<String, Integer> menu = baseEntity.getEatingMap();
                    if (menu == null) continue;
                    for (String type : menu.keySet()) {
                        for (BaseEntity base : countEntity.keySet()) {
                            if (base == null) continue;
                            if (type.equals(base.getIcon())) {

                                BaseEntity entity = baseEntity.getEntityByName(base.getIcon(), population);
                                if (entity != null) {
                                    int probability = baseEntity.getEatingMap().getOrDefault(entity.getIcon(), 0);
                                    int random = new Random().nextInt(100);

                                    if (random < probability) {
                                        checkForSatiety(baseEntity, entity);
                                        currentCell.removeEntity(entity);// животное съело данное существо
                                        int count = eatenAnimalsByType.getOrDefault(base.getIcon(), 0);
                                        eatenAnimalsByType.put(base.getIcon(), count + 1);//заполняем карту съеденных животных для статистики
                                        population.removeEntity(entity);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Количество съеденных сущностей:");
        for (String icons : eatenAnimalsByType.keySet()) {
            System.out.print(icons + ": " + eatenAnimalsByType.get(icons));
        }
        System.out.println();
        System.out.println("Количество сущностей умерших от голода:");
        for (String icons : starvedToDeath.keySet()) {
            System.out.print(icons + ": " + starvedToDeath.get(icons));
        }
        System.out.println();
    }

    public void checkForSatiety(BaseEntity baseEntity, BaseEntity entity) {
        double kilogramToSaturation = baseEntity.getKilogramToSaturation();
        double weight = entity.getWeight();
        double saturation = weight - kilogramToSaturation;
        if (saturation >= 0) {
            baseEntity.setEnergyLevel(100);
        } else {
            int newEnergy = (int) (baseEntity.getEnergyLevel() + weight * 100 / kilogramToSaturation);
            baseEntity.setEnergyLevel(newEnergy);
        }
    }

    public void performBreeding(AnimalFactory animalFactory, BaseEntityPopulation population) throws
            IOException, InstantiationException, IllegalAccessException {
        Map<String, Integer> newBabyList = new HashMap<>();
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                Cell currentCell = table[x][y];
                Map<BaseEntity, Integer> breedingPairs = currentCell.getAnimalCounts(population);
                for (BaseEntity baseEntity : breedingPairs.keySet()) {
                    List<BaseEntity> newBaby = animalFactory.createAnimals(baseEntity.getValueBreed(), baseEntity.getName());
                    for (BaseEntity entity : newBaby) {
                        if (currentCell.getAnimalCount(entity) < entity.getMaxNumber()) {
                            currentCell.addEntity(entity);
                            int count = newBabyList.getOrDefault(entity.getIcon(), 0);
                            newBabyList.put(entity.getIcon(), count + 1);//заполняем карту рожденных животных для статистики
                            population.addAnimal(entity);
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Количество сущностей родившихся на острове:");
        for (String icons : newBabyList.keySet()) {
            System.out.print(icons + ": " + newBabyList.get(icons));
        }
        System.out.println();
    }


    private static Direction setRandomMove() {
        int randomBehavior = (int) (Math.random() * 4) + 1;
        Direction key = null;
        if (randomBehavior == 1)
            key = Direction.LEFT;
        else if (randomBehavior == 2)
            key = Direction.RIGHT;
        else if (randomBehavior == 3)
            key = Direction.UP;
        else if (randomBehavior == 4)
            key = Direction.DOWN;
        return key;
    }

}
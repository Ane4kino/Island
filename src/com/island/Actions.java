package com.island;

import com.google.common.collect.Table;
import com.island.BaseEntity.BaseEntity;
import com.island.frame.Cell;
import com.island.frame.Direction;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;

public class Actions {
    private Cell[][] table;

    public Actions(Cell[][] table) {
        this.table = table;
    }

    public void move(Cell[][] table) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Cell currentCell = table[x][y];
                List<BaseEntity> entities = currentCell.getEntities();
                Iterator<BaseEntity> iterator = entities.iterator();

                while (iterator.hasNext()) {
                    BaseEntity entity = iterator.next();
                    int movementRadius = 1;
//                            entity.getMovementRange();
                    Direction randomMove = setRandomMove();
                    int newX = x + (randomMove == Direction.LEFT ? -movementRadius : randomMove == Direction.RIGHT ? movementRadius : 0);
                    int newY = y + (randomMove == Direction.UP ? -movementRadius : randomMove == Direction.DOWN ? movementRadius : 0);

                    // Проверяем, что новые координаты находятся в пределах острова
                    if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                        Cell newCell = table[newX][newY];
                        newCell.addEntity(entity);
                        iterator.remove(); // Удаляем entity из текущей ячейки
                        currentCell.removeEntity(entity);
                    }
                }

            }
        }
    }


    public void performBreeding(AnimalFactory animalFactory, BaseEntityPopulation population) throws IOException, InstantiationException, IllegalAccessException {
        for (int x = 0; x < HEIGHT; x++) {
            for (int y = 0; y < WIDTH; y++) {
                Cell currentCell = table[x][y];
                Map<BaseEntity, Integer> newBreedingPairs = new HashMap<>();
                Map<String, Integer> breedingPairs = currentCell.getBreedingPairs(population);
                for (Map.Entry<String, Integer> entry : breedingPairs.entrySet()) {
                    BaseEntity baseEntity = currentCell.getEntityBySymbol(entry.getKey());
                    newBreedingPairs.computeIfAbsent(baseEntity, k -> 0); // добавляем ключ, если его ещё нет
                    newBreedingPairs.compute(baseEntity, (k, v) -> v + entry.getValue()); // увеличиваем значение ключа на значение из старой мапы
                }

//                entrySet().stream()
//                        .filter(entry -> entry.getKey().getAge() >= entry.getKey().getBreedingAge())
//                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() / 2));


                for (BaseEntity baseEntity : newBreedingPairs.keySet()) {
                    List<BaseEntity> newBaby = animalFactory.createAnimals(baseEntity.getValueBreed(), baseEntity.getName());
                    for (BaseEntity entity : newBaby) {
                        if (currentCell.getAnimalCount(entity) < entity.getMaxNumber()) {
                            currentCell.addEntity(entity);
                            population.addAnimal(entity);
                        }
                    }
                }
            }
        }
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

    //    public interface Movable  {
//        void move(Table.Cell currentCell, Table.Cell targetCell, List<BaseEntity> entitiesInTargetCell);
//
//    }
    public interface Name {
        String getName();
    }

    public interface PositionAnimals {
        int positionX();

        int positionY();
    }

    public interface AnimalType {
        AnimalTypeEnum getType();
    }

    public interface Eating {
        public void eat();

    }

    public interface Reproduce {
        int getReproduce();
    }

    public interface Die {
        public void die();

    }

}
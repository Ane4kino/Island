package com.island;

import com.google.common.collect.Table;
import com.island.BaseEntity.BaseEntity;
import com.island.frame.Cell;
import com.island.frame.Direction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;

public class Actions {
    private Cell[][] table;

    public Actions(Cell[][] table) {
        this.table = table;
    }

    public void move(BaseEntityPopulation population, Cell[][] table) {
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
    public void performBreeding(AnimalFactory animalFactory,BaseEntityPopulation population) throws IOException {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell currentCell = table[i][j];
                Map<BaseEntity, Integer> breedingPairs = currentCell.getBreedingPairs();


                for (Map.Entry<BaseEntity, Integer> entry : breedingPairs.entrySet()) {

                    BaseEntity type = entry.getKey();
                    int count= currentCell.getAnimalCount(type);
                    int numBreedingPairs = entry.getValue();

                    for (int k = 0; k < numBreedingPairs; k++) {
                        List<BaseEntity> newEntities = animalFactory.createAnimals(type.getValueBreed(), type.getName());
                        for (BaseEntity entity : newEntities) {
                            currentCell.addEntity(entity);
                            population.addAnimal(entity);
                        }
                    }
                }

                List<BaseEntity> entities = currentCell.getEntities();
                for (BaseEntity entity : entities) {
                    if (entity.getAge() >= entity.getMaxAge()) {
                        currentCell.removeEntity(entity);
                        entity.setIsAlive(false);
                        population.removeDeadEntities();
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
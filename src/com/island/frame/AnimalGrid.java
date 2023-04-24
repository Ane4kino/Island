package com.island.frame;

import com.island.AnimalFactory;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntityPopulation;

import java.io.IOException;
import java.util.*;

import static com.island.Constants.HEIGHT;
import static com.island.Constants.WIDTH;

public class AnimalGrid {
    //    private Map<AnimalPosition, List<BaseEntity>> animalPositionListMap;
    private Cell[][] table;

    public AnimalGrid() {
        table = new Cell[WIDTH][HEIGHT];
    }

    public Cell[][] getTable() {
        return table;
    }

//    public static Cell getCell(int x, int y) {
//        return table[x][y];
//    }

//    public void addAnimalToCell(BaseEntity entity, int x, int y) {
//        getCell(x, y).addEntity(entity);
//    }

    public AnimalGrid(BaseEntityPopulation population, AnimalFactory animalFactory) throws IOException {
        // Инициализация поля table
        table = new Cell[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                table[x][y] = new Cell(population);
                populate(animalFactory);
            }
        }
    }

    public void setTable(Cell[][] table) {
        this.table = table;
    }

    public void startGrid(AnimalFactory animalFactory, Cell cell) throws IOException {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {

                table[x][y].addAnimalToCell(cell, animalFactory);

            }
        }
    }


    public void populate(AnimalFactory animalFactory) throws IOException {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Cell cell = table[x][y];
                // добавляем все животные из популяции, которые находятся в текущей ячейке
                    cell.addAnimalToCell(cell, animalFactory);

            }
        }
    }

    // Метод для получения списка сущностей на определенной позиции
//    public List<BaseEntity> getEntitiesAtPosition(AnimalPosition position) {
//        return animalPositionListMap.getOrDefault(position, new ArrayList<>());
//    }

//    public void move(BaseEntityPopulation population, Cell[][] table) {
//        for (int x = 0; x < WIDTH; x++) {
//            for (int y = 0; y < HEIGHT; y++) {
//                Cell currentCell = table[x][y];
//                List<BaseEntity> entities = currentCell.getEntities();
//                Iterator<BaseEntity> iterator = entities.iterator();
//                while (iterator.hasNext()) {
//                    BaseEntity entity = iterator.next();
//                    if (entity.isAlive()) {
//                        Direction randomMove = setRandomMove();
//                        int newX = x + (int) +(randomMove == Direction.LEFT ? -1 : randomMove == Direction.RIGHT ? 1 : 0);
//                        int newY = y + (int) (randomMove == Direction.UP ? -1 : randomMove == Direction.DOWN ? 1 : 0);
//
//                        // Проверяем, что новые координаты находятся в пределах острова
//                        if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
//                            Cell newCell = table[newX][newY];
//                            newCell.addEntities(entities);
//                            iterator.remove(); // Удаляем entity из текущей ячейки
//                        }
//                    }
//                }
//            }
//        }
//    }


//    public void move(BaseEntityPopulation population) {
//        for (int i = 0; i < WIDTH; i++) {
//            for (int j = 0; j < HEIGHT; j++) {
//                Cell cell = getTable()[i][j];
//                List<BaseEntity> entitiesInCell = new ArrayList<>(cell.getEntities());
//                for (int n = 0; n < entitiesInCell.size(); n++) {
//                    Direction randomMove = setRandomMove();
////                    int newX = entitiesInCell.get(n).getPosition().getX()-1;
////                    int newY = entitiesInCell.get(n).getPosition().getY()-1;
//
//                    int newX = entitiesInCell.get(n).getPosition().getX() + (randomMove == Direction.LEFT ? -1 : randomMove == Direction.RIGHT ? 1 : 0);
//                    int newY = entitiesInCell.get(n).getPosition().getY() + (randomMove == Direction.UP ? -1 : randomMove == Direction.DOWN ? 1 : 0);
//
//                    if (randomMove == Direction.LEFT || randomMove == Direction.RIGHT) {
//                        if (newX >= 0 && newX < WIDTH) {
//                            BaseEntity animal = entitiesInCell.get(n);
//                            Cell oldCell = getCell(animal.getPosition().getX(), animal.getPosition().getY());
//                            oldCell.removeEntity(animal);
//                            animal.setPosition(newX, newY);
//                            addAnimalToCell(animal, newX, newY);
//                        }
//                    } else if (randomMove == Direction.UP || randomMove == Direction.DOWN) {
//                        if (newY >= 0 && newY < HEIGHT) {
//                            BaseEntity animal = entitiesInCell.get(n);
//                            Cell oldCell = getCell(animal.getPosition().getX(), animal.getPosition().getY());
//                            oldCell.removeEntity(animal);
//                            animal.setPosition(newX, newY);
//                            addAnimalToCell(animal, newX, newY);
//
//                        }
//                    }
//                }
//            }
//        }
//    }


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

    public void printAllGrid(BaseEntityPopulation population) {
        for (int i = 0; i < WIDTH; i++) {
            System.out.println();
            for (int j = 0; j < HEIGHT; j++) {
                Cell currentCell = getTable()[i][j];
                System.out.print(currentCell.getFormattedContent(population));
            }
            System.out.println();
        }
    }


    public void printGrid(BaseEntityPopulation population) {
        Map<String, Integer> baseEntityCounts = new HashMap<>();
        String icon = null;
        for (BaseEntity animals : population.getBaseEntity()) {
            icon = animals.getSymbol();
            baseEntityCounts.put(icon, baseEntityCounts.getOrDefault(icon, 0) + 1);
        }
        System.out.println("Количество животных на острове:");
        for (
                String icons : baseEntityCounts.keySet()) {
            System.out.println(icons + ": " + baseEntityCounts.get(icons));
        }
    }
}



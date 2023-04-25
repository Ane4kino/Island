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

    public void setCountMapInCell(HashMap<String, Integer> countMapInCell) {
        this.countMapInCell = countMapInCell;
    }

    public HashMap<String, Integer> getCountMapInCell() {
        return countMapInCell;
    }

    private HashMap<String, Integer> countMapInCell;


//    public static Cell getCell(int x, int y) {
//        return table[x][y];
//    }

//    public void addAnimalToCell(BaseEntity entity, int x, int y) {
//        getCell(x, y).addEntity(entity);
//    }

    public AnimalGrid(BaseEntityPopulation population) throws IOException {
        // Инициализация поля table
        table = new Cell[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                table[x][y] = new Cell(population);
                populate(population);

            }
        }
        setTable(table);
    }

    public void setTable(Cell[][] table) {
        this.table = table;
    }

    public void populate(BaseEntityPopulation population) throws IOException {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Cell cell = table[x][y];
                for (BaseEntity entity : population.getBaseEntity())
                    // добавляем все животные из популяции, которые находятся в текущей ячейке
                    cell.addEntity(entity);

            }
        }
    }

    public void populateTable(AnimalFactory animalFactory,BaseEntityPopulation population) throws IOException {
        // Создаем список животных и растений, которые будем добавлять на таблицу
        List<BaseEntity> entities = null;
//        HashMap<String, Integer> countMapInCell = new HashMap<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                entities = new ArrayList<>();
                int horseCount = (int) (Math.random() * 3) + 1;
                // Создаем заданное количество животных каждого типа на фабрике и добавляем в список
                entities.addAll(animalFactory.createAnimals(horseCount, "Horse").getBaseEntity());
                int wolfCount = (int) (Math.random() * 3) + 1;
                entities.addAll(animalFactory.createAnimals(wolfCount, "Wolf").getBaseEntity());
                int foxCount = (int) (Math.random() * 3) + 1;
                entities.addAll(animalFactory.createAnimals(foxCount, "Fox").getBaseEntity());
                int mouseCount = (int) (Math.random() * 3) + 1;
                entities.addAll(animalFactory.createAnimals(mouseCount, "Mouse").getBaseEntity());
                int plantsCount = (int) (Math.random() * 3) + 1;
                entities.addAll(animalFactory.createAnimals(plantsCount, "Plants").getBaseEntity());
                for (BaseEntity entity : entities) {
                    table[x][y].addEntity(entity);
//                countMapInCell.put(entities.get(0).getSymbol(),horseCount);
//                countMapInCell.put(entities.get(1).getSymbol(),wolfCount);
//                countMapInCell.put(entities.get(2).getSymbol(),foxCount);
//                countMapInCell.put(entities.get(3).getSymbol(),mouseCount);
//                countMapInCell.put(entities.get(4).getSymbol(),plantsCount);
//            //                for (BaseEntity entity : entities) {
//                    table[x][y].addCountMapToCell(countMapInCell);
//                for (Map.Entry<String, Integer> entry : countMapInCell.entrySet()) {
//                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                }
//                }
            }
        }

        setTable(table);
    }


    public void move(BaseEntityPopulation population, Cell[][] table) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Cell currentCell = table[x][y];
                List<BaseEntity> entities = currentCell.getEntities();
                Iterator<BaseEntity> iterator = entities.iterator();
                while (iterator.hasNext()) {
                    BaseEntity entity = iterator.next();
                    if (entity.isAlive()) {
                        Direction randomMove = setRandomMove();
                        int newX = x + (int) +(randomMove == Direction.LEFT ? -1 : randomMove == Direction.RIGHT ? 1 : 0);
                        int newY = y + (int) (randomMove == Direction.UP ? -1 : randomMove == Direction.DOWN ? 1 : 0);

                        // Проверяем, что новые координаты находятся в пределах острова
                        if (newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                            Cell newCell = table[newX][newY];
                            newCell.addEntities(entities);
                            iterator.remove(); // Удаляем entity из текущей ячейки
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

    public void printAllGrid(BaseEntityPopulation population) {

        for (int x = 0; x < WIDTH; x++) {
            System.out.println();
            for (int y = 0; y < HEIGHT; y++) {
                Cell currentCell = getTable()[x][y];
                System.out.print(currentCell.getFormattedContent(population, table));
            }
            System.out.println();
        }
    }
    public void printCountMapInCell(BaseEntityPopulation population) {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Map<String, Integer> countMap = table[x][y].getAnimalCountByType(table,x,y);
                System.out.print("[" + x + "," + y + "]: ");
                for (String symbol : table[x][y].getAllSymbols(population)) {
                    int count = countMap.getOrDefault(symbol, 0);
                    System.out.print(symbol + ": " + count + " ");
                }
                System.out.println();
            }
        }
    }

    public List<BaseEntity> getEntities() {
        List<BaseEntity> entities = new ArrayList<>();
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[x].length; y++) {
                entities.addAll(table[x][y].getPopulation(table).getBaseEntity());
            }
        }
        return entities;
    }


    public void printGrid(BaseEntityPopulation population) {
        Map<String, Integer> baseEntityCounts = new HashMap<>();
        String icon = null;
        for (BaseEntity animals : population.getBaseEntity()) {
            icon = animals.getSymbol();
            baseEntityCounts.put(icon, baseEntityCounts.getOrDefault(icon, 0) + 1);
        }
        System.out.println("Количество животных на острове:");
        for (String icons : baseEntityCounts.keySet()) {
            System.out.println(icons + ": " + baseEntityCounts.get(icons));
        }
    }
}



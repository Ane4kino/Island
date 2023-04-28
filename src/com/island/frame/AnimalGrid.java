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

    public void populateTable(AnimalFactory animalFactory, BaseEntityPopulation population) throws IOException {
        // Создаем список животных и растений, которые будем добавлять на таблицу
        List<BaseEntity> entities = null;
//        HashMap<String, Integer> countMapInCell = new HashMap<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                entities = new ArrayList<>();

                // Создаем заданное количество животных каждого типа на фабрике и добавляем в список

                int horseCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> horses = animalFactory.createAnimals(horseCount, "Horse");
                for (BaseEntity entity : horses) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }

                int wolfCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> wolves = animalFactory.createAnimals(wolfCount, "Wolf");
                for (BaseEntity entity : wolves) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }

                int foxCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> foxes = animalFactory.createAnimals(foxCount, "Fox");
                for (BaseEntity entity : foxes) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }

                int mouseCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> mice = animalFactory.createAnimals(mouseCount, "Mouse");
                for (BaseEntity entity : mice) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }

                int plantsCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> plants = animalFactory.createAnimals(plantsCount, "Plants");
                for (BaseEntity entity : plants) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }

                for (BaseEntity entity : entities) {
                    table[x][y].addEntity(entity);

                }
            }
        }
        setTable(table);
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



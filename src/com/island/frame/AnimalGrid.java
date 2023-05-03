package com.island.frame;

import com.island.AnimalFactory;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntityPopulation;

import java.io.IOException;
import java.util.*;


public class AnimalGrid {
    public static final int WIDTH = 3;
    public static final int HEIGHT = 3;
    private Cell[][] table;

    public AnimalGrid() {
        table = new Cell[WIDTH][HEIGHT];
    }

    public Cell[][] getTable() {
        return table;
    }
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

                int mouseCount = (int) (Math.random() * 10) + 1;
                List<BaseEntity> mice = animalFactory.createAnimals(mouseCount, "Mouse");
                for (BaseEntity entity : mice) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }

                int plantsCount = (int) (Math.random() * 10) + 1;
                List<BaseEntity> plants = animalFactory.createAnimals(plantsCount, "Plants");
                for (BaseEntity entity : plants) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int bearCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> bear = animalFactory.createAnimals(bearCount, "Bear");
                for (BaseEntity entity : bear) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int boaCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> boa = animalFactory.createAnimals(boaCount, "Boa");
                for (BaseEntity entity : boa) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int eagleCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> eagle = animalFactory.createAnimals(eagleCount, "Eagle");
                for (BaseEntity entity : eagle) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int rabbitCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> rabbit = animalFactory.createAnimals(rabbitCount, "Rabbit");
                for (BaseEntity entity : rabbit) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int goatCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> goat = animalFactory.createAnimals(goatCount, "Goat");
                for (BaseEntity entity : goat) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int sheepCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> sheep = animalFactory.createAnimals(sheepCount, "Sheep");
                for (BaseEntity entity : sheep) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int boarCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> boar = animalFactory.createAnimals(boarCount, "Boar");
                for (BaseEntity entity : boar) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int buffaloCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> buffalo = animalFactory.createAnimals(buffaloCount, "Buffalo");
                for (BaseEntity entity : buffalo) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int caterpillarCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> caterpillar = animalFactory.createAnimals(caterpillarCount, "Caterpillar");
                for (BaseEntity entity : caterpillar) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int duckCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> duck = animalFactory.createAnimals(duckCount, "Duck");
                for (BaseEntity entity : duck) {
                    population.addAnimal(entity);
                    entities.add(entity);
                }
                int deerCount = (int) (Math.random() * 3) + 1;
                List<BaseEntity> deer = animalFactory.createAnimals(deerCount, "Deer");
                for (BaseEntity entity : deer) {
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

    public void printGrid(BaseEntityPopulation population) {
        Map<String, Integer> baseEntityCounts = new HashMap<>();
        String icon = null;
        for (BaseEntity animals : population.getBaseEntity()) {
            icon = animals.getIcon();
            baseEntityCounts.put(icon, baseEntityCounts.getOrDefault(icon, 0) + 1);
        }
        System.out.println("Количество животных на острове:");
        for (String icons : baseEntityCounts.keySet()) {
            System.out.print(icons + ": " + baseEntityCounts.get(icons));
        }
    }
}



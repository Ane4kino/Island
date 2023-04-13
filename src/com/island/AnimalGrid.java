package com.island;

import com.island.BaseEntity.BaseEntity;

import java.util.*;

import static com.island.Constants.*;

public class AnimalGrid {
    private Map<AnimalPosition, List<BaseEntity>> animalPositionListMap;
    private Cell[][] table;
    public AnimalGrid() {
        table = new Cell[WIDTH][HEIGHT];
    }

    public Cell[][] getTable() {
        return table;
    }

    public AnimalGrid(BaseEntityPopulation population, List<BaseEntity> baseEntities) {
        // Инициализация поля table
        table = new Cell[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                table[x][y] = new Cell();
            }
        }

        // Инициализация animalPositionListMap и вызов populate(population)
        animalPositionListMap = new HashMap<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                AnimalPosition position = getAnimalPosition(x, y);
                animalPositionListMap.put(position, new ArrayList<>());
            }
        }
        populate(population);
    }

    public Map<AnimalPosition, List<BaseEntity>> getAnimalPositionListMap() {
        return animalPositionListMap;
    }

    public void populate(BaseEntityPopulation population) {
        for (BaseEntity animal : population.getBaseEntity()) {
            AnimalPosition position = animal.getPosition();
            Cell cell = getTable()[position.getX()][position.getY()]; // получаем ячейку из таблицы
            List<BaseEntity> entitiesInCell = cell.getEntities(); // получаем список животных в ячейке
            entitiesInCell.add(animal); // добавляем текущего животного в список
            // обновляем animalPositionListMap с учетом текущего животного
            animalPositionListMap.put(position, entitiesInCell);
        }

    }

    public void addAnimal(BaseEntity animal, AnimalPosition position) {
        List<BaseEntity> animals = animalPositionListMap.get(position);
        if (animals == null) {
            animals = new ArrayList<>();
            animalPositionListMap.put(position, animals);
        }
        animals.add(animal);
    }

    public void removeAnimal(BaseEntity animal, AnimalPosition position) {
        animalPositionListMap.get(position).remove(animal);
    }


//    public void moveAnimals() {
//        Map<AnimalPosition, List<BaseEntity>> newGrid = new HashMap<>();
//
//        // Создаем копию коллекции animalPositionListMap, чтобы избежать ConcurrentModificationException
//        Map<AnimalPosition, List<BaseEntity>> animalPositionListMapCopy = new HashMap<>(animalPositionListMap);
//
//        for (List<BaseEntity> baseEntities : animalPositionListMapCopy.values()) {
//            for (BaseEntity baseEntity : baseEntities) {
//                List<AnimalPosition> newPositions = baseEntity.move(baseEntity.getPosition(), this);
//
//                for (AnimalPosition newPosition : newPositions) {
//                    if (!newGrid.containsKey(newPosition)) {
//                        newGrid.put(newPosition, new ArrayList<>());
//                    }
//                    newGrid.get(newPosition).add(baseEntity);
//                }
//            }
//        }
//    }

    public List<AnimalPosition> getPositions(BaseEntity animal) {
        List<AnimalPosition> positions = new ArrayList<>();
        for (AnimalPosition position : animalPositionListMap.keySet()) {
            if (animalPositionListMap.get(position).contains(animal)) {
                positions.add(position);
            }
        }
        return positions;
    }

    public AnimalPosition getAnimalPosition(int x, int y) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            return new AnimalPosition(x, y);
        } else {
            return null;
        }
    }

    //    public void moveAnimals(AnimalPosition position, List<AnimalPosition> newPositions, BaseEntity animal) {
//        for (AnimalPosition newPosition : newPositions) {
//            addAnimal(animal, newPosition);
//        }
//    }


    public void printAllGrid(BaseEntityPopulation population) {
        for (int i = 0; i < getTable().length; i++) {
            System.out.println();
            for (int j = 0; j < getTable()[i].length; j++) {
                Cell cell = getTable()[i][j];
                List<BaseEntity> entitiesInCell = cell.getEntities();
                Map<String, Integer> baseEntityCounts = new HashMap<>();

                // Создаем копию списка entitiesInCell для итерации
                List<BaseEntity> entitiesCopy = new ArrayList<>(entitiesInCell);
                for (BaseEntity animal : entitiesCopy) {
                    // Добавляем существующего животного в ячейку
                    cell.addAnimal(animal);
                    String icon = animal.getSymbol();
                    baseEntityCounts.put(icon, baseEntityCounts.getOrDefault(icon, 0) + 1);
                }
                System.out.print(cell.getFormattedContent() + " ");
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



package com.island;

import java.util.*;

import static com.island.Constants.*;

public class AnimalGrid {
    private Map<AnimalPosition, List<Animals>> animalPositionListMap;

    public AnimalGrid(List<Animals> animals) {
        animalPositionListMap = new HashMap<>();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                AnimalPosition position = new AnimalPosition(x, y);
                animalPositionListMap.put(position, new ArrayList<>());
            }
        }
        for (Animals animal : animals) {
            AnimalPosition position = animal.getPosition();
            List<Animals> animalList = animalPositionListMap.get(position);
            animalList.add(animal);
        }
    }

    public Map<AnimalPosition, List<Animals>> getAnimalPositionListMap() {
        return animalPositionListMap;
    }
    public void populate(AnimalPopulation population) {
        for (Animals animal : population.getAnimals()) {
            AnimalPosition position = animal.getPosition();
            List<Animals> animalsInCell = animalPositionListMap.computeIfAbsent(position, k -> new ArrayList<>());
            animalsInCell.add(animal);
        }
    }

    public void  addAnimal(Animals animal, AnimalPosition position) {
        List<Animals> animalsInCell = animalPositionListMap.getOrDefault(position, new ArrayList<>());
        animalsInCell.add(animal);
        animalPositionListMap.put(position, animalsInCell);
    }

    public void removeAnimal(Animals animal, AnimalPosition position) {
        animalPositionListMap.get(position).remove(animal);
    }


    public void moveAnimals() {
        Map<AnimalPosition, List<Animals>> newGrid = new HashMap<>();

        for (List<Animals> animals : animalPositionListMap.values()) {
            for (Animals animal : animals) {
                List<AnimalPosition> newPositions = animal.move(animal.getPosition(), this);

                for (AnimalPosition newPosition : newPositions) {
                    if (!newGrid.containsKey(newPosition)) {
                        newGrid.put(newPosition, new ArrayList<>());
                    }
                    newGrid.get(newPosition).add(animal);
                }
            }
        }
        animalPositionListMap = newGrid;
    }

    public List<AnimalPosition> getPositions(Animals animal) {
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

    public void moveAnimals(AnimalPosition position, List<AnimalPosition> newPositions, Animals animal) {
        for (AnimalPosition newPosition : newPositions) {
            addAnimal(animal, newPosition);
        }
    }

//    private void printGrid() {
//        // Создаем пустую сетку, заполненную пробелами
//        String[][] grid = new String[rows][cols];
//        for (String[] row : grid) {
//            Arrays.fill(row, ".");
//        }
//
//        // Добавляем животных в соответствующие ячейки
//        for (Animals animal : animalsList) {
//            AnimalPosition position = animal.getPosition();
//            int row = position.getRow();
//            int col = position.getCol();
//            grid[row][col] = animal.getSymbol();
//        }
//
//        // Выводим сетку в консоль
//        for (String[] row : grid) {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
//    }
}

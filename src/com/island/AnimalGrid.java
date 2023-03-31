package com.island;

import com.island.AnimalPosition;
import com.island.Animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnimalGrid {
    private final int rows;
    private final int cols;
    private final List<Animals> animalsList;

    public AnimalGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.animalsList = new ArrayList<>();
    }

    public void addAnimal(Animals animal) {
        animalsList.add(animal);
    }

    public void runSimulation(int steps) {
        // Рандомизируем порядок животных в списке
        Collections.shuffle(animalsList);

        // Запускаем симуляцию на заданное количество шагов
        for (int i = 0; i < steps; i++) {
            for (Animals animal : animalsList) {
                AnimalPosition currentPosition = animal.getPosition();
                int newRow = currentPosition.getRow();
                int newCol = currentPosition.getCol();
                int moveCells = animal.getMovementRange();

                // Проверяем, что животное не выходит за границы сетки
                if (newRow + moveCells >= rows) {
                    newRow = rows - 1;
                } else if (newRow - moveCells < 0) {
                    newRow = 0;
                } else {
                    newRow += (int) (Math.random() * (2 * moveCells + 1)) - moveCells;
                }
                if (newCol + moveCells >= cols) {
                    newCol = cols - 1;
                } else if (newCol - moveCells < 0) {
                    newCol = 0;
                } else {
                    newCol += (int) (Math.random() * (2 * moveCells + 1)) - moveCells;
                }

                // Обновляем позицию животного
                AnimalPosition newPosition = new AnimalPosition(newRow, newCol);
                animal.setPosition(newPosition);
            }
            printGrid();
        }
    }

    private void printGrid() {
        // Создаем пустую сетку, заполненную пробелами
        char[][] grid = new char[rows][cols];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }

        // Добавляем животных в соответствующие ячейки
        for (Animals animal : animalsList) {
            AnimalPosition position = animal.getPosition();
            int row = position.getRow();
            int col = position.getCol();
            grid[row][col] = animal.getSymbol();
        }

        // Выводим сетку в консоль
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
        System.out.println();
    }
}

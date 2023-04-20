package com.island.frame;

import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntityPopulation;

import static com.island.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {
    private String content; // содержимое ячейки
    private int animalCount; // количество животных
    private List<BaseEntity> entities;
    private Map<String, Integer> animalCountsByType; // количество животных по типам

    public List<BaseEntity> getEntities() {
        if (entities == null) {
            entities = new ArrayList<>();
        }
        return entities;
    }

    public void removeEntity(BaseEntity entity) {
        entities.remove(entity);
        String symbol = entity.getSymbol();
        int count = animalCountsByType.getOrDefault(symbol, 0);
        if (count > 0) {
            animalCountsByType.put(symbol, count - 1);
        }
    }


    public Cell(BaseEntityPopulation population) {
        this.content = "--0 шт"; // инициализация содержимого ячейки
        this.animalCount = 0; // инициализация количества животных
        this.animalCountsByType = new HashMap<>(); // инициализация карты количества животных по типам
        this.entities = new ArrayList<>(population.getBaseEntity());
    }

    // Метод для добавления животного в ячейку
    public void addEntity(BaseEntity animal) {
        entities.add(animal);
        String symbol = animal.getSymbol();
        animalCount = animalCountsByType.getOrDefault(symbol, 0);
        animalCountsByType.put(symbol, animalCount + 1);
        animalCount++;
    }

//    public void printAnimalCountsByType() {
//        for (Map.Entry<String, Integer> entry : animalCountsByType.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//            System.out.println(getFormattedContent(po));
//        }
//    }

    public void clearEntities() {
        entities.clear();
    }

    public boolean containsAnimal(BaseEntity baseEntity) {
        for (BaseEntity animalInCell : entities) {
            if (animalInCell.equals(baseEntity)) {
                return true;
            }
        }
        return false;
    }
//    public void addAnimalToCell(Cell cell, BaseEntity animal) {
//        if (containsAnimal(animal)) {
//            // Если животное уже присутствует в ячейке, увеличиваем счетчик
//            int animalCount = getAnimalCount(animal);
//            setAnimalCount(animal, animalCount + 1);
//        } else {
//            // Если животное отсутствует в ячейке, добавляем его и устанавливаем счетчик в 1
//            addAnimal(animal);
//            setAnimalCount(animal, 1);
//        }
//        cell.addAnimal(animal);
//    }



    // Установка количества животных определенного типа в ячейке
    public void setAnimalCount(BaseEntity entity, int count) {
        String type = entity.getSymbol();
        int currentCount = animalCountsByType.getOrDefault(type, 0);
        animalCountsByType.put(type, currentCount + count);
    }

    // Очистка счетчиков количества животных по типам в ячейке
    public void clearAnimalCountsByType() {
        animalCountsByType.clear();
    }

    // Метод для обновления содержимого ячейки на основе карты количества животных по типам
    private void updateContent(BaseEntityPopulation population) {
        StringBuilder sb = new StringBuilder();
        for (String symbol : population.getAllSymbols()) {
            int count = animalCountsByType.getOrDefault(symbol, 0);
            sb.append(symbol).append("-").append(count).append(" шт, ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        } else {
            sb.append("--0 шт");
        }
        content = sb.toString();

    }

    // Метод для вывода содержимого ячейки в формате, подходящем для вывода на экран
    public String getFormattedContent(BaseEntityPopulation population) {
        updateContent(population);
        return String.format("%-40s", content);
    }

    // Метод для получения общего количества животных в ячейке
    public int getAnimalCount(BaseEntity baseEntity) {
        animalCount = 0;
        for (BaseEntity animal : entities) {
            if (animal.getSymbol().equals(baseEntity.getSymbol())) {
                animalCount++;
            }
        }
        return animalCount;
    }
}


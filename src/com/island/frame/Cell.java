package com.island.frame;

import com.island.AnimalFactory;
import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntityPopulation;

import static com.island.Constants.*;

import java.io.IOException;
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
    public void addAnimals(String type, int count, AnimalFactory animalFactory) throws IOException {
        BaseEntityPopulation population = animalFactory.createAnimals(count, type);
        entities.addAll(population.getBaseEntity());
    }
    public void addAnimalToCell(Cell cell, AnimalFactory animalFactory) throws IOException {
        int numberCount = (int) (Math.random() * 4) + 1;
        cell.addAnimals("Horse", numberCount, animalFactory);
        numberCount = (int) (Math.random() * 4) + 1;
        cell.addAnimals("Mouse", numberCount, animalFactory);
        numberCount = (int) (Math.random() * 4) + 1;
        cell.addAnimals("Fox", numberCount, animalFactory);
        numberCount = (int) (Math.random() * 4) + 1;
        cell.addAnimals("Plants", numberCount, animalFactory);
        numberCount = (int) (Math.random() * 4) + 1;
        cell.addAnimals("Wolf", numberCount, animalFactory);
    }


    public void addEntities(List<BaseEntity> newEntities) {
        if (entities == null) {
            entities = new ArrayList<>();
        }
        entities.addAll(newEntities);
        for (BaseEntity entity : newEntities) {
            String symbol = entity.getSymbol();
            int count = animalCountsByType.getOrDefault(symbol, 0);
            animalCountsByType.put(symbol, count + 1);
        }
        animalCount = entities.size();
    }

    public void removeEntity(BaseEntity entity) {
        entities.remove(entity);
        String symbol = entity.getSymbol();
        int count = animalCountsByType.getOrDefault(symbol, 0);
        if (count > 0) {
            animalCountsByType.put(symbol, count - 1);
        }
        animalCount = entities.size();
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
        int count = animalCountsByType.getOrDefault(symbol, 0);
        animalCountsByType.put(symbol, count + 1);
        animalCount = entities.size();
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

//    public void addAnimalToCell(BaseEntityPopulation population) {
//
//        List<BaseEntity> entities = population.getBaseEntity();
//
//        for (BaseEntity entity : population.getBaseEntity()) {
//            // проверяем, есть ли в ячейке уже такое животное
//            for (BaseEntity entityInCell : entities) {
//                if (entityInCell.equals(entity)) {
//                    // если есть, увеличиваем количество животных этого типа в ячейке
//                    int count = population.getCount(entityInCell.getType());
//                    setEntityCount(entityInCell, count + 1);
//                    return;
//                }
//            }
//
//            // если животного такого типа еще нет в ячейке, добавляем его и устанавливаем количество в 1
//            addEntity(entity);
//            setEntityCount(entity, 1);
//        }
//    }

    public void setEntityCount(BaseEntity entity, int count) {
        String type = entity.getSymbol();
        animalCountsByType.put(type, count);
    }


    // Получение количества животных определенного типа в ячейке
    public int getAnimalCount(String animalType) {
        return animalCountsByType.getOrDefault(animalType, 0);
    }

    // Установка количества животных определенного типа в ячейке
    public void setAnimalCount(String animalType, int count) {
        animalCountsByType.put(animalType, count);
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


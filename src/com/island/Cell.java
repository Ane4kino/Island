package com.island;

import com.island.BaseEntity.BaseEntity;

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
        return entities;
    }

    public void removeEntity(BaseEntity entity) {
        entities.remove(entity);
    }
    public Cell() {
        this.content = "--0 шт"; // инициализация содержимого ячейки
        this.animalCount = 0; // инициализация количества животных
        this.animalCountsByType = new HashMap<>(); // инициализация карты количества животных по типам
        this.entities = new ArrayList<>();
    }

    // Метод для добавления животного в ячейку
    public void addAnimal(BaseEntity animal) {
        entities.add(animal);
        String symbol = animal.getSymbol();
        animalCount = animalCountsByType.getOrDefault(symbol, 0);
        animalCountsByType.put(symbol, animalCount + 1);
        animalCount++;
    }
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

    // Метод для обновления содержимого ячейки на основе карты количества животных по типам
    private void updateContent() {
        StringBuilder sb = new StringBuilder();
        animalCountsByType.forEach((symbol, count) ->
                sb.append(symbol).append("-").append(count).append(" шт, "));
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        } else {
            sb.append("--0 шт");
        }
        content = sb.toString();
    }

    // Метод для вывода содержимого ячейки в формате, подходящем для вывода на экран
    public String getFormattedContent() {
        updateContent();
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


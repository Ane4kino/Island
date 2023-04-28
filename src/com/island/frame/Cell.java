package com.island.frame;

import com.island.BaseEntity.BaseEntity;
import com.island.BaseEntityPopulation;

import static com.island.Constants.*;

import java.util.*;
import java.util.stream.Collectors;

public class Cell {

    private String content; // содержимое ячейки
    private int animalCount; // количество животных
    private List<BaseEntity> entities;
    private Map<String, Integer> animalCountsByType; // количество животных по типам

    public Cell(BaseEntityPopulation population) {
        this.content = "--0 шт"; // инициализация содержимого ячейки
        this.animalCount = 0; // инициализация количества животных
        this.animalCountsByType = new HashMap<>(); // инициализация карты количества животных по типам
        this.entities = new ArrayList<>(population.getBaseEntity());
    }
//    public void addCountMapToCell(HashMap<String, Integer> animalCountsByType) {
//        this.animalCountsByType = animalCountsByType;
//    }

    public Map<String, Integer> getAnimalCountsByType() {
        return animalCountsByType;
    }

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
        animalCount = entities.size();
    }

    // Метод для добавления животного в ячейку
    public void addEntity(BaseEntity animal) {
        entities.add(animal);
        String symbol = animal.getSymbol();
        int count = animalCountsByType.getOrDefault(symbol, 0);
        animalCountsByType.put(symbol, count + 1);
        animalCount = entities.size();
    }
    public BaseEntity getEntityBySymbol(String symbol) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Объект с символом" + symbol + " не существует."));
    }
    public Map<String, Integer> getBreedingPairs(BaseEntityPopulation population) throws InstantiationException, IllegalAccessException {
        Map<String, Integer> breedingPairs = new HashMap<>();

        // собираем животных, которые достигли возраста размножения
        // и группируем их по типу в map с количеством животных каждого типа
        Map<Class<? extends BaseEntity>, Integer> animalCountsByType = getEntities().stream()
                .filter(entity -> entity.getAge() >= entity.getBreedingAge())
                .collect(Collectors.groupingBy(BaseEntity::getClass, Collectors.summingInt(entity -> 1)));


        for (Map.Entry<Class<? extends BaseEntity>, Integer> entry : animalCountsByType.entrySet()) {
            Class<? extends BaseEntity> animal = entry.getKey();
            int count = entry.getValue();
            int pairCount = count / 2;
            if (pairCount!=0){
                breedingPairs.put(animal.getSimpleName(), pairCount);
            }

        }
       return breedingPairs;
    }


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
    public Map<String, Integer> getAnimalCountByType(Cell[][] table, int x, int y) {

        Map<String, Integer> animalCountByType = new HashMap<>();

        for (BaseEntity entity : table[x][y].getEntities()) {
            String symbol = entity.getSymbol();
            int count = animalCountByType.getOrDefault(symbol, 0);
            animalCountByType.put(symbol, count + 1);

        }
        return animalCountByType;
    }

    private void updateContent(BaseEntityPopulation population, Cell[][] table) {
        StringBuilder sb = null;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                sb = new StringBuilder();
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
        }

    }


    // Метод для вывода содержимого ячейки в формате, подходящем для вывода на экран
    public String getFormattedContent(BaseEntityPopulation population, Cell[][] table) {
        updateContent(population, table);
        return String.format("%-50s", content);
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

    public BaseEntityPopulation getPopulation(Cell[][] table) {
        BaseEntityPopulation population = new BaseEntityPopulation();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                population.getBaseEntity().addAll(table[x][y].getEntities());
            }
        }
        return population;
    }

    public List<String> getAllSymbols(BaseEntityPopulation population) {
        List<String> symbols = new ArrayList<>();
        for (BaseEntity animal : population.getBaseEntity()) {
            String symbol = animal.getSymbol();
            if (!symbols.contains(symbol)) {
                symbols.add(symbol);
            }
        }
        return symbols;
    }
}


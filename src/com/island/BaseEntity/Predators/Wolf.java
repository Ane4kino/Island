package com.island.BaseEntity.Predators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.island.AnimalPosition;
import com.island.AnimalTypeEnum;
import com.island.BaseEntity.BaseEntity;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.island.AnimalTypeEnum.WOLF;
import static com.island.Constants.AMT_WOLF_CUB;

public class Wolf extends BaseEntity {

    private String name;
    private String icon;
    private int age;
    private int maxAge;
    private int movementRange;//диапазон движения
    private int breedingAge;//возраст размножения
    private int maxNumber;//максимальное количество на ячейке
    private double breedingProbability;//вероятность размножения
    private double weight;
    private double kilogramToSaturation;// максимальное значение насыщения
    private Map<String, Integer> eatingMap;


    public String getIcon() {
        return icon;
    }

    public int getAge() {
        return age;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public int getBreedingAge() {
        return breedingAge;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public double getWeight() {
        return weight;
    }

    public double getKilogramToSaturation() {
        return kilogramToSaturation;
    }

    public Map<String, Integer> getEatingMap() {
//        eatingMap=new HashMap<>();
        eatingMap.put("Rabbit", 60);
        eatingMap.put("Mouse", 80);
        eatingMap.put("Deer", 15);
        eatingMap.put("Horse", 10);
        eatingMap.put("Goat", 60);
        eatingMap.put("Sheep", 70);
        return eatingMap;
    }


//    public Wolf() {
//        super();
//    }
//
//    public Wolf(boolean isAlive, AnimalPosition position, ObjectMapper objectMapper, String filePath) throws IOException {
//        super(isAlive, position);
//        Wolf wolf = objectMapper.readValue(new File(filePath), Wolf.class);
//        System.out.println("Read wolf object from file: " + wolf);
//        this.name = wolf.name;
//        this.icon = wolf.icon;
//        this.age = wolf.age;
//        this.maxAge = wolf.maxAge;
//        this.movementRange = wolf.movementRange;
//        this.breedingAge = wolf.breedingAge;
//        this.maxNumber = wolf.maxNumber;
//        this.breedingProbability = wolf.breedingProbability;
//        this.weight = wolf.weight;
//        this.kilogramToSaturation = wolf.kilogramToSaturation;
//        this.objectMapper = objectMapper;
//        System.out.println("Wolf object values after reading from file: " + this);
//    }

    public Wolf(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        AnimalPosition position = new AnimalPosition(0, 0);

        this.name = rootNode.path("name").asText();
        this.icon = rootNode.path("icon").asText();
        this.age = rootNode.path("age").asInt();
        this.maxAge = rootNode.path("maxAge").asInt();
        this.movementRange = rootNode.path("movementRange").asInt();
        this.breedingAge = rootNode.path("breedingAge").asInt();
        this.maxNumber = rootNode.path("maxNumber").asInt();
        this.breedingProbability = rootNode.path("breedingProbability").asDouble();
        this.weight = rootNode.path("weight").asDouble();
        this.kilogramToSaturation = rootNode.path("kilogramToSaturation").asDouble();
        this.isAlive = true;
        this.eatingMap = null;
        this.position = position;
    }




    @Override
    public String getSymbol() {
        return "\uD83D\uDC3A";
    }

    @Override
    public int getReproduce() {
        return AMT_WOLF_CUB;
    }

    @Override
    public AnimalTypeEnum getType() {
        return WOLF;
    }

    @Override
    public String getName() {
        return "волк(ов)";
    }


//    @Override
//    public void move(List<AnimalPosition> adjacentPositions) {
//
//    }

}

package com.island.BaseEntity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.island.BaseEntityPopulation;

import java.util.Map;


public abstract class BaseEntity {
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
    private int energyLevel;
    private int valueBreed;
    public boolean isAlive;
    private Map<String, Integer> eatingMap;
    public String getName() {
        return name;
    }

    public Map<String, Integer> getEatingMap() {
        return eatingMap;
    }
    public double getWeight() {
        return weight;
    }
    public double getKilogramToSaturation() {
        return kilogramToSaturation;
    }
    public String getIcon() {
        return icon;
    }
    public int getValueBreed() {
        return valueBreed;
    }
    public int getEnergyLevel() {
        return energyLevel;
    }
    public int getAge() {
        return age;
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
    public boolean isAlive() {
        return isAlive;
    }
    public int getMaxAge() {
        return maxAge;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void  setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }
    public BaseEntity() {
    }
    @JsonCreator
    public BaseEntity(String name, String icon, int age, int maxAge, int movementRange, int breedingAge, int maxNumber,
                      double breedingProbability, double weight, double kilogramToSaturation, boolean isAlive,Map<String, Integer> eatingMap,int energyLevel) {
        this.name = name;
        this.icon = icon;
        this.age = age;
        this.maxAge = maxAge;
        this.movementRange = movementRange;
        this.breedingAge = breedingAge;
        this.maxNumber = maxNumber;
        this.breedingProbability = breedingProbability;
        this.weight = weight;
        this.kilogramToSaturation = kilogramToSaturation;
        this.isAlive = true;
        this.energyLevel=energyLevel;
        this.eatingMap=eatingMap;

    }

public BaseEntity getEntityByName(String name, BaseEntityPopulation population) {
    for (BaseEntity entity : population.getBaseEntity()) {
        if (entity.getIcon().equals(name)) {
            return entity;
        }
    }
    return null; // если животное с указанным именем не найдено
}
    @Override
    public String toString() {
        return "BaseEntity{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", age=" + age +
                ", movementRange=" + movementRange +
                ", breedingAge=" + breedingAge +
                ", maxNumber=" + maxNumber +
                ", breedingProbability=" + breedingProbability +
                ", weight=" + weight +
                ", kilogramToSaturation=" + kilogramToSaturation +
                ", isAlive=" + isAlive +
                ", maxAge=" + maxAge +
                '}';
    }
}


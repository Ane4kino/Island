package com.island;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AnimalTypeEnum {
    WOLF,
    FOX,
    MOUSE,
    HORSE, AnimalType, AnimalFactory;

    public static List<String>  animalListType(){
        List<String>  listAnimals=  Stream.of(AnimalType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return listAnimals;
    }
}

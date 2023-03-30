package com.island;

import java.util.Map;
import java.util.Set;

import static com.island.BehaviorAnimals.*;
import static com.island.frame.StartPosition.*;


public class Main {
    public static void main(String[] args) {
        startField();
        createListAnimals();
        Set<Map.Entry<AnimalTypeEnum, Integer>> entries = countingAnimals().entrySet();
        for (Map.Entry<AnimalTypeEnum, Integer> pair : entries) {
            AnimalTypeEnum key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println("На поле сейчас: " + value + "объектов под видом " + key);
        }


        for (String[] row : field) {
            printRow(row);
        }

//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
//        frame.add(new Frame(frame));
//        frame.setVisible(true);


    }
}

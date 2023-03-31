package com.island;

import com.island.animals.Fox;

import java.util.Map;
import java.util.Set;

import static com.island.AnimalFactory.createAnimal;
import static com.island.BehaviorAnimals.*;
import static com.island.frame.StartPosition.*;


public class Main {
    public static void main(String[] args) {
        startField();

        startAnimals();
     //   countingAnimals();
        animalsList();

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

package com.island;

import static com.island.BehaviorAnimals.*;
import static com.island.frame.StartPosition.*;



public class Main {
    public static void main(String[] args) {
        startField();

        for (int i = 0; i < createAnimals().size(); i++) {
            startPosition(createAnimals().get(i));
          // setMove(createAnimals().get(i));
        }

        for (String[] row : field) {
            printRow(row);



//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);
//        frame.add(new Frame(frame));
//        frame.setVisible(true);

        }
    }
}

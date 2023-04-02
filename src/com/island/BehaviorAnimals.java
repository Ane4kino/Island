//package com.island;
//
//import com.island.frame.Direction;
//
//import java.util.*;
//
//import static com.island.AnimalTypeEnum.*;
//import static com.island.AnimalTypeEnum.MOUSE;
//import static com.island.Constants.HEIGHT;
//import static com.island.Constants.WIDTH;
//import static com.island.frame.Direction.*;
//import static com.island.frame.StartPosition.field;
//
//
//public class BehaviorAnimals {
//    private Direction direction = Direction.LEFT;
//
////    public static String[][] createListAnimals() {
////        AnimalFactory factory = new AnimalFactory();
////        Animals fox = factory.createAnimal(FOX);
////        field[fox.getX()][fox.getY()] = fox.getSymbol();
////
////        Animals wolf = factory.createAnimal(WOLF);
////        field[wolf.getX()][wolf.getY()] = wolf.getSymbol();
////
////        Animals horse = factory.createAnimal(HORSE);
////        field[horse.getX()][horse.getY()] = horse.getSymbol();
////
////        Animals mouse = factory.createAnimal(MOUSE);
////        field[mouse.getX()][mouse.getY()] = mouse.getSymbol();
////
////        return field;
////    }
//
//    public static void animalsList() {
//        List<Integer[]> foxList = new ArrayList<>();
//        List<Integer[]> wolfList = new ArrayList<>();
//        List<Integer[]> mouseList = new ArrayList<>();
//        List<Integer[]> horseList = new ArrayList<>();
//        int countFox = 0;
//        int countWolf = 0;
//        int countMouse = 0;
//        int countHorse = 0;
//
//        for (int i = 0; i < WIDTH; i++) {
//            for (int j = 0; j < HEIGHT; j++) {
//                switch (field[i][j]) {
//                    case "\uD83E\uDD8A" -> {
//                        foxList.add(new Integer[]{i, j});
//                        countFox++;
//                    }
//                    case "\uD83D\uDC3A" -> {
//                        wolfList.add(new Integer[]{i, j});
//                        countWolf++;
//                    }
//                    case "\uD83D\uDC01" -> {
//                        mouseList.add(new Integer[]{i, j});
//                        countMouse++;
//                    }
//                    case "\uD83D\uDC0E" -> {
//                        horseList.add(new Integer[]{i, j});
//                        countHorse++;
//                    }
//                }
//            }
//        }
//        System.out.println("Всего лис: " + countFox);
//        System.out.println("Всего волков: " + countWolf);
//        System.out.println("Всего мышей: " + countMouse);
//        System.out.println("Всего лошадей: " + countHorse);
//        System.out.println("Координаты лис: ");
//        for (Integer[] foxListe : foxList) {
//            System.out.println(Arrays.toString(foxListe));
//        }
//
//        System.out.println("Координаты волков:");
//        for (Integer[] wolfListe : wolfList) {
//            System.out.println(Arrays.toString(wolfListe));
//        }
//    }
////        public static HashMap<AnimalTypeEnum, Integer[][]> countingAnimals () {
////            Integer[][] positionXY = new Integer[WIDTH][HEIGHT];
////
////            HashMap<AnimalTypeEnum, Integer[][]> countingAnimalsMap = new HashMap<>();
////            int numberAnimals = 0;
////            for (int i = 0; i < WIDTH; i++) {
////                for (int j = 0; j < Constants.HEIGHT; j++) {
////                    if (field[i][j].equals("\uD83E\uDD8A")) {
////                        countingAnimalsMap.put(FOX, positionXY);
////                        numberAnimals++;
////                    }
////                }
////            }
////            Set<Map.Entry<AnimalTypeEnum, Integer[][]>> entries = countingAnimalsMap.entrySet();
////            for (Map.Entry<AnimalTypeEnum, Integer[][]> pair : entries) {
////                AnimalTypeEnum key = pair.getKey();
////                //   Integer[][] value = pair.getValue();
////                System.out.println("На поле сейчас: " + numberAnimals + "объектов под видом " + key);
////            }
////
////            return countingAnimalsMap;
////
////        }
////    public static HashMap<AnimalTypeEnum, Integer> mapAnimals() {
////        HashMap<AnimalTypeEnum, Integer> mapAnimals = new HashMap<>();
////        int numberAnimals = 0;
////        mapAnimals.put(AnimalFactory, numberAnimals++);
////        return mapAnimals;
////    }
//
//
////    public static HashMap<AnimalTypeEnum, Integer> countingAnimals() {
////        Integer[][] positionXY = new Integer[WIDTH][HEIGHT];
////        HashMap<AnimalTypeEnum, Integer[][]> countingAnimalsMap = new HashMap<>();
////        int numberAnimals = 0;
////        for (int i = 0; i < WIDTH; i++) {
////            for (int j = 0; j < Constants.HEIGHT; j++) {
////
////                if (field[i][j].equals("\uD83E\uDD8A")) {
////                    countingAnimalsMap.put(FOX, numberAnimals++);
////                }
////            }
////        }
////        // }
////        return countingAnimalsMap;
////    }
//
////    public void setDirection(Direction direction) {
////        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && createAnimals().get(0).positionX() == createAnimals().get(1).positionX()) {
////            return;
////        }
////        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && createAnimals().get(0).positionY() == createAnimals().get(1).positionY()) {
////            return;
////        }
////
////        if (direction == Direction.UP && this.direction == Direction.DOWN) {
////            return;
////        } else if (direction == Direction.LEFT && this.direction == Direction.RIGHT) {
////            return;
////        } else if (direction == Direction.RIGHT && this.direction == Direction.LEFT) {
////            return;
////        } else if (direction == Direction.DOWN && this.direction == Direction.UP) {
////            return;
////        }
////
////        this.direction = direction;
////    }
//
////        public static Direction setRandomMove () {
////            int randomBehavior = (int) (Math.random() * 4) + 1;
////            Direction key = null;
////            if (randomBehavior == 1)
////                key = LEFT;
////            else if (randomBehavior == 2)
////                key = RIGHT;
////            else if (randomBehavior == 3)
////                key = UP;
////            else if (randomBehavior == 4)
////                key = DOWN;
////            return key;
////        }
//
////    public static Animals setMove(A) {
////
////        if (setRandomMove().equals(LEFT))
////            startAnimals()
////        else if (setRandomMove().equals(RIGHT))
////            listOfAllAnimals.setX(x) = listOfAllAnimals.getX() + listOfAllAnimals.getMovement();
////        else if (setRandomMove().equals(UP))
////            listOfAllAnimals.setY(y) = listOfAllAnimals.getY() + listOfAllAnimals.getMovement();
////        else if (setRandomMove().equals(DOWN))
////            listOfAllAnimals.setY(y) = listOfAllAnimals.getY() - listOfAllAnimals.getMovement();
////
////        return listOfAllAnimals;
////    }
//}
//

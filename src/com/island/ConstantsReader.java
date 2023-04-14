//package com.island;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.island.BaseEntity.Herbivores.Horse;
//import com.island.BaseEntity.Herbivores.Mouse;
//import com.island.BaseEntity.Predators.Fox;
//import com.island.BaseEntity.Predators.Wolf;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class ConstantsReader {
//    private static final String FILE_PATH = "src/com/island/file/informationIsland.json"; // путь к файлу JSON с константами
//
//    public static void main(String[] args) {
//        ObjectMapper gson = new ObjectMapper();
//        try {
//            Fox fox = gson.readValue(new File(FILE_PATH), Fox.class);
//            System.out.println(fox);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    private static class Constants {
//        private Horse horse;
//        private Wolf wolf;
//        private Mouse mouse;
//        private Fox fox;
//
//        public Horse getHorse() {
//            return horse;
//        }
//
//        public Wolf getWolf() {
//            return wolf;
//        }
//
//        public Mouse getMouse() {
//            return mouse;
//        }
//
//        public Fox getFox() {
//            return fox;
//        }
//    }
//}

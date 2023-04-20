package com.island;

import com.google.common.collect.Table;
import com.island.BaseEntity.BaseEntity;

import java.util.List;

public class Actions {

//    public interface Movable  {
//        void move(Table.Cell currentCell, Table.Cell targetCell, List<BaseEntity> entitiesInTargetCell);
//
//    }
    public interface Name {
        String getName();
    }

    public interface PositionAnimals {
        int positionX();

        int positionY();
    }

    public interface AnimalType {
        AnimalTypeEnum getType();
    }

    public interface Eating {
        public void eat();

    }

    public interface Reproduce {
        int getReproduce();
    }

    public interface Die {
        public void die();

    }

}
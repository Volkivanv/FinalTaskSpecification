package src.core.animals.impl.packanimals.impl;

import src.core.animals.impl.packanimals.PackAnimal;

import java.sql.Date;

public class Horse extends PackAnimal {
    public Horse(int id, String name, String type, Date birthDate) {
        super(id, name, type, birthDate);
    }
}

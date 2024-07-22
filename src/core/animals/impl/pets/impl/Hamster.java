package src.core.animals.impl.pets.impl;

import src.core.animals.impl.pets.Pet;

import java.sql.Date;

public class Hamster extends Pet {
    public Hamster(int id, String name, String type, Date birthDate) {
        super(id, name, type, birthDate);
    }
}

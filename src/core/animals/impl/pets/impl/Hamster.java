package src.core.animals.impl.pets.impl;

import src.core.animals.impl.pets.Pet;

import java.util.Date;

public class Hamster extends Pet {
    public Hamster(int id, String name, Date birthDate) {
        super(id, name, "Hamster", birthDate);
    }
}

package src.core.animals.impl.pets.impl;

import src.core.animals.impl.pets.Pet;

import java.util.Date;

public class Cat extends Pet {
    public Cat(int id, String name, Date birthDate) {
        super(id, name, "Cat", birthDate);
    }
}

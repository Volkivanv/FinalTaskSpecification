package src.core.animals.impl.pets.impl;

import src.core.animals.impl.pets.Pet;

import java.util.Date;

public class Dog extends Pet {
    public Dog(int id, String name,  Date birthDate) {
        super(id, name, "Dog", birthDate);
    }
}

package src.core.animals.impl.pets;

import src.core.animals.Animal;

import java.sql.Date;

public abstract class Pet extends Animal {
    public Pet(int id, String name, String type, Date birthDate) {
        super(id, name, type, birthDate);
    }
}

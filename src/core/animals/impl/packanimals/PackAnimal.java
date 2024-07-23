package src.core.animals.impl.packanimals;

import src.core.animals.Animal;

import java.sql.Date;

public abstract class PackAnimal extends Animal {
    public PackAnimal(int id, String name, String type, Date birthDate) {
        super(id, name, type, birthDate);
    }
}

package src.core.animals.impl.packanimals.impl;

import src.core.animals.impl.packanimals.PackAnimal;

import java.sql.Date;

public class Donkey extends PackAnimal {
    public Donkey(int id, String name, String type, Date birthDate) {
        super(id, name, type, birthDate);
    }
}

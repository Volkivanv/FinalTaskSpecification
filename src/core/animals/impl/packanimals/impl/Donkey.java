package src.core.animals.impl.packanimals.impl;

import src.core.animals.impl.packanimals.PackAnimal;

import java.util.Date;

public class Donkey extends PackAnimal {
    public Donkey(int id, String name, Date birthDate) {
        super(id, name, "Donkey", birthDate);
    }
}

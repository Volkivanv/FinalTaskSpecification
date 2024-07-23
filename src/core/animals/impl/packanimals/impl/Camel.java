package src.core.animals.impl.packanimals.impl;

import src.core.animals.impl.packanimals.PackAnimal;

import java.sql.Date;

public class Camel extends PackAnimal {
    public Camel(int id, String name, Date birthDate) {
        super(id, name, "Camel", birthDate);
    }
}

package src.core.animals.impl.pets;

import src.core.animals.Animal;

import java.util.ArrayList;
import java.util.Date;

public abstract class Pet extends Animal {
    public Pet(int id, String name, String type, Date birthDate) {
        super(id, name, type, birthDate);
        availableCommands = new ArrayList<>();
        availableCommands.add("Sit");
        availableCommands.add("Play");
        availableCommands.add("Stay");
        availableCommands.add("Fetch");
        availableCommands.add("Pounce");
        availableCommands.add("Roll");
        availableCommands.add("Hide");
        availableCommands.add("Paw");
        availableCommands.add("Bark");
        availableCommands.add("Scratch");
        availableCommands.add("Spin");
        availableCommands.add("Meow");
        availableCommands.add("Jump");
    }
}

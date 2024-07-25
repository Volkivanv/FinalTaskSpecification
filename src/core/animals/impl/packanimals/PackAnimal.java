package src.core.animals.impl.packanimals;

import src.core.animals.Animal;

import java.util.ArrayList;
import java.util.Date;


public abstract class PackAnimal extends Animal {

    public PackAnimal(int id, String name, String type, Date birthDate) {

        super(id, name, type, birthDate);
        availableCommands = new ArrayList<>();
        // Add available commands for pack animals here
        availableCommands.add("Trot");
        availableCommands.add("Canter");
        availableCommands.add("Gallop");
        availableCommands.add("Walk");
        availableCommands.add("Run");
        availableCommands.add("Carry Load");
        availableCommands.add("Bray");
        availableCommands.add("Trot");
        availableCommands.add("Sit");
        availableCommands.add("Jump");
        availableCommands.add("Kick");
    }
}

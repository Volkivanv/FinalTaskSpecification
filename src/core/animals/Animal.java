package src.core.animals;

import src.core.commands.Command;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal{
    private int id;
    private String name;
    private String type;
    private Date birthDate;
    private List<Command> commands;

    public Animal(int id, String name, String type, Date birthDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public List<Command> getCommands() {
        return commands;
    }





}

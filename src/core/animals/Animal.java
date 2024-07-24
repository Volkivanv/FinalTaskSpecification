package src.core.animals;

import src.core.commands.Command;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal{
    private int id;
    private String name;
    private String type;
    private Date birthDate;
    private List<Command> commands;
    protected List<String> availableCommands;

    public Animal(int id, String name, String type, Date birthDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        commands = new ArrayList<>();
        availableCommands = new ArrayList<>();
    }

    public void addCommand(String newCommand) {
        Command command = new Command(newCommand);
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

    public String commandsToString() {
        StringBuilder sb = new StringBuilder();
        if (commands.isEmpty()) {
            sb.append("Животное на знает команд! ");
        } else {
            sb.append("Животное знает следующие команды: ");
            for (Command command : commands) {
                sb.append(command.getCommand()).append(", ");
            }
          //  sb.append("\n");
        }
        return sb.toString();
    }

    public List<String> getNewAvailableCommands() {
        List<String> newCommands = new ArrayList<String>();
        for (String command : availableCommands) {
            if (!commands.stream().anyMatch(c -> c.getCommand().equals(command))) {
                newCommands.add(command);
            }
        }
        return newCommands;
    }



    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", birthDate=" + birthDate + '\'' +
                ", " + commandsToString() + '}';
    }





}

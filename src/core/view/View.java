package src.core.view;

import src.core.Counter;
import src.core.animals.Animal;
import src.core.animals.impl.packanimals.impl.Camel;
import src.core.animals.impl.packanimals.impl.Donkey;
import src.core.animals.impl.packanimals.impl.Horse;
import src.core.animals.impl.pets.impl.Cat;
import src.core.animals.impl.pets.impl.Dog;
import src.core.animals.impl.pets.impl.Hamster;
import src.core.logger.Logger;
import src.core.util.Doings;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static src.core.util.Doings.*;

public class View {
    private Logger logger;

    private final List<String> validOperators;

    private List<Animal> animals;

//    private Counter counter;

    private Integer count;

    public View(Logger logger) {
        this.logger = logger;
        this.validOperators = Arrays.stream(Doings.values())
                .map(Doings::doing)
                .collect(Collectors.toList());
        animals = new ArrayList<>();
        this.count = 0;
//        counter = new Counter();
    }

    private boolean isInvalidOperator(String doing) {
        return !validOperators.contains(doing);
    }

    public void Run() {
        // Запуск приложения
        logger.log("Запуск приложения...");
        // Выполнение основного функционала приложения
        do {
            String doing = getDoing().toUpperCase();
            if (Objects.equals(doing, "ADD")) {
              try {
                  addAnimal();
//                counter.add();
              } catch (Exception e) {}
            } else if (Objects.equals(doing, "LIST")) {
                listAnimals();
            } else if (Objects.equals(doing, "DELETE")) {
                deleteAnimal();
//                counter.sub();
            } else if (Objects.equals(doing, "TRAIN")) {
                trainAnimal();
            } else if (Objects.equals(doing, "COUNT")) {
                System.out.println("Количество животных " + this.count);
            }

            // Проверка условий выхода из цикла
        } while (Objects.equals(prompt(), "y"));
        // Завершение работы приложения
        logger.log("Приложение завершило работу.");
    }

    private void trainAnimal() {
        int id = Integer.parseInt(prompt("Введите ID животного для обучения: "));
        Animal animalToTrain = animals.stream()
                .filter(animal -> animal.getId() == id)
                .findFirst()
                .orElse(null);
        if (animalToTrain != null) {
            animalToTrain.commandsToString();
            System.out.print("Животное может изучить следующие команды: " + animalToTrain.getNewAvailableCommands() + "\n");
            String newCommand = prompt("Введите новую команду: ");
            if (animalToTrain.getNewAvailableCommands().contains(newCommand)) {
                animalToTrain.addCommand(newCommand);
            }
            logger.log("Тренировано животное: " + animalToTrain);
        } else {
            System.out.println("Животное с таким ID не найдено.");
        }
    }

    private void deleteAnimal() {
        int id = Integer.parseInt(prompt("Введите ID животного для удаления: "));
        Animal animalToDelete = animals.stream()
                .filter(animal -> animal.getId() == id)
                .findFirst()
                .orElse(null);
        if (animalToDelete != null) {
            animals.remove(animalToDelete);
            System.out.println("Животное с ID " + id + " удалено.");
            logger.log("Удалено животное: " + animalToDelete);
            try(Counter counter = new Counter()){
                this.count = counter.sub(this.count);
            } catch (Exception e) {}
        } else {
            System.out.println("Животное с таким ID не найдено.");
        }
    }

    private void listAnimals() {
        List<Animal> sortedAnimals = animals;
        sortedAnimals.sort(Comparator.comparing(Animal::getBirthDate));
        System.out.println("Список животных:");
        animals.forEach(System.out::println);
        logger.log("Выведен список животных");
    }

    //получаем подтверждение продолжения
    private String prompt() {
        String mess = "";
        do {
            Scanner in = new Scanner(System.in);
            System.err.println("Continue?... (y/n)");
            mess = in.nextLine().toLowerCase();
        } while (!Objects.equals(mess, "y")&&!Objects.equals(mess, "n"));
        return mess;
    }

    private String prompt(String something) {
        Scanner in = new Scanner(System.in);
        System.err.println(something);
        return in.nextLine();
    }

    private String getDoing() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите одно из действий (" + ADD + ", " + DELETE + ", " + LIST + ", " + TRAIN + ", " + COUNT + "): ");
        String doing = in.nextLine();
        while (true) {
            if (isInvalidOperator(doing)) {
                System.err.println("Введено не правильное действие. "
                        + "Введите правильное из (" + ADD + ", " + DELETE + ", " + LIST + ", " + TRAIN + ", " + COUNT + "): ");
                doing = in.nextLine();
            } else return doing;
        }
    }

    Animal inputPackAnimal(int id, String typeAnimal) {
        // Выбор вида животного
        Animal animal = switch (typeAnimal) {
            case "Horse" -> new Horse(id, prompt("Введите имя лошади: "), inputBirthDate());
            case "Camel" -> new Camel(id, prompt("Введите имя верблюда: "), inputBirthDate());
            case "Donkey" -> new Donkey(id, prompt("Введите имя осла: "), inputBirthDate());
            default -> throw new IllegalArgumentException("Неверный вид животного: " + typeAnimal);
        };
        return animal;
    }

    Animal inputPet(int id, String typeAnimal) {
        // Выбор вида животного
        Animal animal = switch (typeAnimal) {
            case "Cat" -> new Cat(id, prompt("Введите имя котика: "), inputBirthDate());
            case "Dog" -> new Dog(id, prompt("Введите имя собаки: "), inputBirthDate());
            case "Hamster" -> new Hamster(id, prompt("Введите имя хомяка: "), inputBirthDate());
            default -> throw new IllegalArgumentException("Неверный вид животного: " + typeAnimal);
        };
        return animal;
    }

    private Date inputBirthDate() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дату рождения в формате dd.mm.yyyy: ");
        String birthDateStr = in.nextLine();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            return dateFormat.parse(birthDateStr);
        } catch (ParseException e) {
            System.err.println("Неверный формат даты. Пример: 01.01.2000");
            return inputBirthDate();
        }
    }


    public void addAnimal() throws Exception {
        int id = getMaxId() + 1;
        do {
            String inp = prompt("Если хотите ввести вьючное животное введите '0', если питомца '1': ");
            if (inp.equals("0")) {
                String typeAnimal = prompt("Введите вид вьючного животного 'Horse', 'Camel', Donkey': ");
                animals.add(inputPackAnimal(id, typeAnimal));
                try(Counter counter = new Counter()){
                    this.count = counter.add(this.count);
                } catch (InterruptedException e) {}
                break;
            } else if (inp.equals("1")) {
                String typeAnimal = prompt("Введите вид вьючного животного 'Cat', 'Dog', Hamster': ");
                animals.add(inputPet(id, typeAnimal));
                try(Counter counter = new Counter()){
                    this.count = counter.add(this.count);
                } catch (InterruptedException e) {}
                break;
            }
        }
        while (true);
        logger.log("Добавлено животное: " + animals.getLast().toString());
    }

    private int getMaxId() {
        if (animals.isEmpty()) return 0;
        return animals.stream().mapToInt(Animal::getId).max().getAsInt();
    }
}

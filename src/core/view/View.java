package src.core.view;

import src.core.animals.Animal;
import src.core.logger.Logger;
import src.core.util.Doings;

import java.util.*;
import java.util.stream.Collectors;

import static src.core.util.Doings.*;

public class View {
    private Logger logger;

    private final List<String> validOperators;

    private List<Animal> animals;
    public View(Logger logger) {
        this.logger = logger;
        this.validOperators = Arrays.stream(Doings.values())
                .map(Doings::doing)
                .collect(Collectors.toList());
        animals = new ArrayList<>();
    }

    private boolean isInvalidOperator(String doing) {
        return !validOperators.contains(doing);
    }
    public void Run(){
        // Запуск приложения
        logger.log("Запуск приложения...");
        // Выполнение основного функционала приложения
        do {
            String doing = getDoing();

            // Проверка условий выхода из цикла
        } while (Objects.equals(prompt(), "y"));
        // Завершение работы приложения
        logger.log("Приложение завершило работу.");
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String getDoing() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите одно из действий (" + ADD +", "+DELETE+", "+ LIST+", " + TRAIN + "): ");
        String doing = in.nextLine();
        while (true) {
            if (isInvalidOperator(doing)) {
                System.err.println("Введено не правильное действие. "
                        + "Введите правильное из (" + ADD +", "+DELETE+", "+ LIST+", " + TRAIN + "): ");
                doing = in.nextLine();
            } else return doing;
        }
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);
        logger.log("Добавлено животное: " + animal.getName());
    }
}

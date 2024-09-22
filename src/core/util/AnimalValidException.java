package src.core.util;

import java.io.IOException;

public class AnimalValidException extends IOException {
    public AnimalValidException() {
        super("Некорректные данные о животном");
    }
}

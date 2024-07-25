package src;

import src.core.logger.Logger;
import src.core.logger.impl.LoggerTxt;
import src.core.view.View;

public class Main {
    public static void main(String[] args) {
        // создаем LoggerTxt для записи действий
        Logger logger = new LoggerTxt("log.txt");
        // создаем экземпляр View и передаем LoggerTxt в конструкторе
        View view = new View(logger);
        view.Run();

    }
}

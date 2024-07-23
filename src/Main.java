package src;

import src.core.logger.Logger;
import src.core.logger.impl.LoggerTxt;
import src.core.view.View;

public class Main {
    public static void main(String[] args) {
        Logger logger = new LoggerTxt("log.txt");
        View view = new View(logger);
        view.Run();

    }
}

package src.core.logger.impl;

import src.core.logger.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LoggerTxt implements Logger {
    String filePath;
    public LoggerTxt(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(filePath, true))
        {

            Date date = new Date();
            writer.write(date+ ": " + message);

            writer.append('\n');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}

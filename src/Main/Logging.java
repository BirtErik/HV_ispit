package Main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Klasa sluzi za obradu logova
 * @author Erik Birt
 */
public class Logging {
    private final Logger logger = Logger.getLogger("Logging");
    public Logging(){
        FHandler();
    }
    public void FHandler(){
        try{
            FileHandler fileHandler = new FileHandler("log.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        }catch (IOException e){
            logger.warning("Log datoteka se nije uspijela kreirati: " + e.getMessage());
        }
    }
    public void LoggingError(Throwable throwable){
        logger.severe(throwable.getMessage());
    }
    public void LoggingInfo(String info){
        logger.info(info);
    }

}

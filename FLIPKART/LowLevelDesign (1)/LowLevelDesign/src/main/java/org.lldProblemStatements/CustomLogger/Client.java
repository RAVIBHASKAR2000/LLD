package main.java.org.lldProblemStatements.CustomLogger;

public class Client {
    public static void main(String[] args){
        Logging logger = Logging.getInstance();
        logger.setConfig(new LogConfig(LogLevel.DEBUG,new ConsoleLogStream()));

        logger.info("I'm a message");
        logger.debug("I'm a message");
        logger.warn("I'm a message");
        logger.error("I'm a message");
    }
}

package main.java.org.lldProblemStatements.CustomLogger;

public class Logging {
    private static Logging instance;
    private LogConfig config;


    private Logging(){}

    public static Logging getInstance(){
        if(instance==null){
            instance = new Logging();
        }
        return instance;
    }

    public void setConfig(LogConfig config){
        this.config = config;
    }

    private void log(String message, LogLevel level){
        LogMessage currentMessage = new LogMessage(message, level);
        if(level.ordinal()>=config.getCurrentLevel().ordinal()){
            config.getCurrentStream().stream(currentMessage);
        }
    }

    public void info(String message){
        log(message,LogLevel.INFO);
    }

    public void debug(String message){
        log(message,LogLevel.DEBUG);
    }

    public void warn(String message){
        log(message,LogLevel.WARN);
    }

    public void error(String message){
        log(message,LogLevel.ERROR);
    }

    public void fatal(String message){
        log(message,LogLevel.FATAL);
    }
}

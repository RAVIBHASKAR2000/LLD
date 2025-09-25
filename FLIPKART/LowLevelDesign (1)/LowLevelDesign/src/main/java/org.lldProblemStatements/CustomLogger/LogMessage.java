package main.java.org.lldProblemStatements.CustomLogger;

public class LogMessage {
    private final String message;
    private final LogLevel level;
    private final long timeStamp;

    public LogMessage(String message, LogLevel level) {
        this.message = message;
        this.level = level;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getLogMessage(){
        return "["+level+"] "+this.timeStamp+" " + message;
    }
}

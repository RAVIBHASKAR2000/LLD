package main.java.org.lldProblemStatements.LoggingFrameworkWithBlockingQueue;

public class LogRecord {
    private final String message;
    private final LogLevel level;
    private final long timestamp;
    private final Throwable throwable;

    public LogRecord(String message, LogLevel level, Throwable throwable) {
        this.message = message;
        this.level = level;
        this.timestamp = System.currentTimeMillis();
        this.throwable = throwable;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLevel() {
        return level;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String format(){
        return "[" + timestamp + "] [" + level + "] " + message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}

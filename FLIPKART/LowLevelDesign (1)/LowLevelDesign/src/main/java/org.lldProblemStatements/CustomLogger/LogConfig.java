package main.java.org.lldProblemStatements.CustomLogger;

public class LogConfig {
    private LogLevel currentLevel;
    private LogStream currentStream;

    public LogConfig(LogLevel currentLevel, LogStream currentStream) {
        this.currentLevel = currentLevel;
        this.currentStream = currentStream;
    }

    public LogLevel getCurrentLevel(){
        return currentLevel;
    }

    public LogStream getCurrentStream() {
        return currentStream;
    }

    public void setCurrentLevel(LogLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setCurrentStream(LogStream currentStream) {
        this.currentStream = currentStream;
    }
}

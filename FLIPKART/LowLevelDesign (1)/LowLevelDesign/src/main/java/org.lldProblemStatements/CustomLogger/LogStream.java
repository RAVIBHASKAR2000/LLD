package main.java.org.lldProblemStatements.CustomLogger;

public interface LogStream {
    void stream(LogMessage message);
}

class ConsoleLogStream implements LogStream{
    @Override
    public void stream(LogMessage message){
        System.out.println(message.getLogMessage());
    }
}

class DataBaseLogStream implements LogStream{
    @Override
    public void stream(LogMessage message){
        System.out.println(message.getLogMessage());
    }
}

class FileLogStream implements LogStream{
    @Override
    public void stream(LogMessage message){
        System.out.println(message.getLogMessage());
    }
}
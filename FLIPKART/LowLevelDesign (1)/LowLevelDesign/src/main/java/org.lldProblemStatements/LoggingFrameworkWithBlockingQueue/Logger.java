package main.java.org.lldProblemStatements.LoggingFrameworkWithBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Logger {
    private final BlockingQueue<LogRecord> logQueue;
    private String appName;
    private static Logger instance;
    private LogWorker logWorker;

    private Logger(String appName) {
        logQueue = new LinkedBlockingQueue<>();
        this.appName = appName;
        this.logWorker = new LogWorker(logQueue);
        Thread logWorkerThread = new Thread(this.logWorker);
        logWorkerThread.start();
    }

    public static Logger getLogger(String appName){
        if(instance==null){
            instance = new Logger(appName);
        }
        return instance;
    }

    public void log(LogLevel level, String message, Throwable t){
        if(!logQueue.offer(new LogRecord(message,level,t))){
            System.out.println("Logger overflowed!");
        }
    }

    public void info(String message){
        if(!logQueue.offer(new LogRecord(message,LogLevel.INFO,null))){
            System.out.println("Logger overflowed!");
        }
    }

    public void debug(String message){
        if(!logQueue.offer(new LogRecord(message,LogLevel.DEBUG,null))){
            System.out.println("Logger overflowed!");
        }
    }

    public void warn(String message){
        if(!logQueue.offer(new LogRecord(message,LogLevel.WARN,null))){
            System.out.println("Logger overflowed!");
        }
    }

    public void error(String message){
        if(!logQueue.offer(new LogRecord(message,LogLevel.ERROR,null))){
            System.out.println("Logger overflowed!");
        }
    }

    public void fatal(String message){
        if(!logQueue.offer(new LogRecord(message,LogLevel.FATAL,new Exception("FATAL: "+message)))){
            System.out.println("Logger overflowed!");
        }
    }
}

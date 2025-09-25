package main.java.org.lldProblemStatements.LoggingFrameworkWithBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class LogWorker implements Runnable{
    private final BlockingQueue<LogRecord> logQueue;
    private volatile boolean running;

    public LogWorker(BlockingQueue<LogRecord> logQueue){
        this.logQueue = logQueue;
        this.running = true;
    }

    @Override
    public void run(){
        // consuming logs from the BlockingQueue
        while(running || !logQueue.isEmpty()){
            try {
                LogRecord log = logQueue.poll(200, TimeUnit.SECONDS);
                if(log!=null){
                    System.out.println(log.format());
                    if(log.getThrowable()!=null){
                        log.getThrowable().printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

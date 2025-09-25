package main.java.org.lldProblemStatements.LoggingFrameworkWithBlockingQueue;

public class Client {
    public static void main(String[] args) throws InterruptedException{
        Logger logger = Logger.getLogger("Akshay");

        Runnable taskInfo = () -> {
            for(int i=0;i<5;i++){
                logger.info("I'm a info level message from "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable taskDebug = () -> {
            for(int i=0;i<5;i++){
                logger.debug("I'm a debug level message from "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable taskWarn = () -> {
            for(int i=0;i<5;i++){
                logger.warn("I'm a warn level message from "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable taskError = () -> {
            for(int i=0;i<5;i++){
                logger.error("I'm a error level message from "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable taskFatal = () -> {
            for(int i=0;i<5;i++){
                logger.fatal("I'm a fatal level message from "+Thread.currentThread().getName());
            }
        };

        new Thread(taskInfo).start();
        new Thread(taskDebug).start();
        new Thread(taskWarn).start();
        new Thread(taskError).start();
        new Thread(taskFatal).start();

    }
}

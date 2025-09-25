import dto.Logger;
import dto.Sink;
import enums.LogLevel;
import enums.LoggerType;
import enums.SinkType;
import javafx.util.Pair;
import repository.LoggerConfiguration;
import service.LoggerService;
import util.FileWriterUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) throws FileNotFoundException {

        Sink sink = new Sink(SinkType.FILE, LogLevel.ERROR);
        List<Sink> sinkList = new ArrayList<>();
        sinkList.add(sink);

        LoggerConfiguration loggerConfiguration =new LoggerConfiguration(new Logger("Shubham",sinkList,15, LoggerType.ASYNC,"any format"));

        LoggerService loggerService=new LoggerService();

            try {

                loggerService.logMessage("Hey Beautiful",LogLevel.FATAL);
                loggerService.logMessage("Hey dumb",LogLevel.ERROR);
                loggerService.logMessage("Hey Beautiful",LogLevel.INFO);
                loggerService.logMessage("Hey dumb",LogLevel.DEBUG);
                loggerService.logMessage("Hey Beautiful",LogLevel.WARN);


                Runnable task = () -> {
                    for (int i = 0; i < 20; i++) {
                        loggerService.logMessage("This is log message " + i, LogLevel.ERROR);
                    }
                };

                Thread thread1 = new Thread(task);
                Thread thread2 = new Thread(task);
                thread1.start();
                thread2.start();
            }
            catch (RuntimeException e){
                System.out.println(e);
            }

    }
}

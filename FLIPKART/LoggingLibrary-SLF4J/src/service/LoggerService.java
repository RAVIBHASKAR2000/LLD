package service;

import dto.Logger;
import dto.Sink;
import enums.LogLevel;
import repository.LoggerConfiguration;
import util.FileWriterUtil;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LoggerService {
    Logger loggerConfiguration = LoggerConfiguration.getLogger();


    public void logMessage(String messageContent, LogLevel logLevel) {

        List<LogLevel> logLevelList = Arrays.asList(LogLevel.values());

        for (Sink sink : loggerConfiguration.getSinks()) {

            if (logLevelList.indexOf(logLevel) < logLevelList.indexOf(sink.getLogLevel())) {
                continue;
            }

            switch (sink.getSinkType()) {
                case STDOUT: {
                    synchronized (this) {
                        if (loggerConfiguration.getLoggerType().equals("SYNC"))
                            System.out.println(messageFormatter(messageContent, logLevel));
                        else {
                            Queue<String> messageQueue = new ConcurrentLinkedQueue<>();
                            if (messageQueue.size() <= loggerConfiguration.getBufferSize()) {
                                messageQueue.add(messageContent);
                                System.out.println(messageFormatter(messageQueue.poll(), logLevel));
                            }
                        }
                    }
                }
                break;
                case FILE: {
                    synchronized (this) {
                        if (loggerConfiguration.getLoggerType().equals("SYNC"))
                            FileWriterUtil.writeOutputToFile(messageFormatter(messageContent, logLevel));
                        else {
                            Queue<String> messageQueue = new ConcurrentLinkedQueue<>();
                            if (messageQueue.size() <= loggerConfiguration.getBufferSize()) {
                                messageQueue.add(messageContent);
                                FileWriterUtil.writeOutputToFile(messageFormatter(messageQueue.poll(), logLevel));
                            }
                        }
                    }
                }
                break;
                case DATABASE: {

                }
                break;
                default: {
                    System.out.println("INVALID INPUT");
                }
            }


        }


    }

    Date generateDate(){

        Date now = new Date();
        if (!loggerConfiguration.getTs_format().equals("any format")) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(loggerConfiguration.getTs_format());
                String formattedDate = sdf.format(now);
                System.out.println("Formatted date: " + formattedDate);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid date format: " + loggerConfiguration.getTs_format());
            }
        }
        return now;
    }

    String messageFormatter(String messageContent,LogLevel logLevel){
        Date formattedDate =generateDate();
        return String.format("%s\t [%s] \t%s", formattedDate, logLevel, messageContent);
    }
}

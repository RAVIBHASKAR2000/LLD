package repository;

import dto.Logger;

public class LoggerConfiguration {
    public LoggerConfiguration(Logger logger1) {
        logger=logger1;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        LoggerConfiguration.logger = logger;
    }

    static Logger logger;

}

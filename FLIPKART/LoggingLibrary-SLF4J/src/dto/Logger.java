package dto;

import enums.LoggerType;

import java.util.List;

public class Logger {
    String loggerName;
    List<Sink> sinks;
    int bufferSize;
    LoggerType loggerType;
    String ts_format;

    public LoggerType getLoggerType() {
        return loggerType;
    }

    public void setLoggerType(LoggerType loggerType) {
        this.loggerType = loggerType;
    }

    public String getTs_format() {
        return ts_format;
    }

    public void setTs_format(String ts_format) {
        this.ts_format = ts_format;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public List<Sink> getSinks() {
        return sinks;
    }

    public void setSinks(List<Sink> sinks) {
        this.sinks = sinks;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public Logger(String loggerName, List<Sink> sinks, int bufferSize,LoggerType loggerType,String ts_format) {
        this.loggerName = loggerName;
        this.sinks = sinks;
        this.bufferSize = bufferSize;
        this.loggerType=loggerType;
        this.ts_format=ts_format;
    }
}

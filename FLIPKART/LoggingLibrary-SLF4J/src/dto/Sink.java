package dto;

import enums.LogLevel;
import enums.SinkType;

public class Sink {
    SinkType sinkType;
    LogLevel logLevel;

    public SinkType getSinkType() {
        return sinkType;
    }

    public void setSinkType(SinkType sinkType) {
        this.sinkType = sinkType;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public Sink(SinkType sinkType, LogLevel logLevel) {
        this.sinkType = sinkType;
        this.logLevel = logLevel;
    }
}

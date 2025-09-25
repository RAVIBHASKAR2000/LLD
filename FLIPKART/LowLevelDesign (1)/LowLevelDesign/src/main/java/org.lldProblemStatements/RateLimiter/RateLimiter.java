package main.java.org.lldProblemStatements.RateLimiter;

public interface RateLimiter {
    boolean allowRequest(Request request);
}

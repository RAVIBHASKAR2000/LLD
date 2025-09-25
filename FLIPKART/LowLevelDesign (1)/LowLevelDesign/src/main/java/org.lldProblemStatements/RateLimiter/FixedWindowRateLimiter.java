package main.java.org.lldProblemStatements.RateLimiter;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class FixedWindowRateLimiter implements RateLimiter {
    private final long maxRequestPerWindow;
    private final long windowSize;
    private HashMap<String, Long> requestCountMap;
    private HashMap<String,Long> requestTimeMap;

    public FixedWindowRateLimiter(long maxRequestPerWindow, long windowSize) {
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.windowSize = windowSize;
        this.requestCountMap = new HashMap<>();
        this.requestTimeMap = new HashMap<>();
    }

    @Override
    public boolean allowRequest(@NotNull Request request) {
        long currentTime = System.currentTimeMillis();
        String clientID = request.getClientID();

        // if the client id is not present add them
        requestTimeMap.putIfAbsent(clientID,currentTime);
        requestCountMap.putIfAbsent(clientID, 0L);

        long lastRequest = requestTimeMap.get(clientID);

        // if the time of last request is greater than the window reset all the data
        if(currentTime-lastRequest>this.windowSize){
            requestTimeMap.put(clientID,currentTime);
            requestCountMap.putIfAbsent(clientID, 0L);
        }

        long currentRequestCount = requestCountMap.get(clientID);

        // if the current number of requests are less than the max permitted value per minute return true
        if(currentRequestCount<= this.maxRequestPerWindow){
            requestCountMap.put(clientID,currentRequestCount+1);
            return true;
        }

        return false;
    }
}

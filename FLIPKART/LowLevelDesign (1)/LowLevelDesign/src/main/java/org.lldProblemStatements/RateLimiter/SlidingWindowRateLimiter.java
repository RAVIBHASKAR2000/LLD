package main.java.org.lldProblemStatements.RateLimiter;
import java.util.*;

public class SlidingWindowRateLimiter implements RateLimiter {
    private final long maxRequestPerWindow;
    private final long windowSize;
    private HashMap<String, Queue<Long>> requestQueue;


    public SlidingWindowRateLimiter(long maxRequestPerWindow, long windowSize) {
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.windowSize = windowSize;
        this.requestQueue = new HashMap<>();
    }

    @Override
    public boolean allowRequest(Request request) {
        long currentTime = System.currentTimeMillis();
        String clientID = request.getClientID();

        // initialise the queue in the clientID was not present previously
        requestQueue.putIfAbsent(clientID,new LinkedList<>());
        var q = requestQueue.get(clientID);

        // pop all the elements in the queue that are outside of the window
        while(!q.isEmpty() && (currentTime-q.peek())>windowSize){
            q.poll();
        }

        // push incoming requests inside queue
        q.add(currentTime);

        // check if the queue size is more than permitted value
        if(q.size()>maxRequestPerWindow){
            return false;
        }

        return true;
    }
}
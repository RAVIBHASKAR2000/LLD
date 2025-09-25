package main.java.org.lldProblemStatements.RateLimiter;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketRateLimiter implements RateLimiter{
    private final long refillIntervalInMillis;
    private final int refillCount;
    private final long maxBucketSize;
    private AtomicLong tokens;
    private Thread refillJob;

    public TokenBucketRateLimiter(long refillInterval, int refillCount, long maxBucketSize){
        this.refillIntervalInMillis = refillInterval;
        this.refillCount = refillCount;
        this.maxBucketSize = maxBucketSize;
        tokens = new AtomicLong(maxBucketSize);

        // start a thread daemon that refills the bucket
        refillJob = new Thread(()->{
            while(true){
                if(tokens.get()<this.maxBucketSize){
                    tokens.addAndGet(this.refillCount);
                }
                try {
                    Thread.sleep(this.refillIntervalInMillis);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        refillJob.setDaemon(true);
        refillJob.start();
    }

    @Override
    public synchronized boolean allowRequest(Request request){
        if(tokens.get()>0){
            tokens.addAndGet(-this.refillCount);
            return true;
        }
        else{
            return false;
        }
    }
}

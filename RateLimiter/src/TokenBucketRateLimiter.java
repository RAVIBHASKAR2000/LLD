import  java.util.*;

import  java.time.Instant;

import  java.time.Duration;

public class TokenBucketRateLimiter implements RateLimiter{

    private int bucket_size;
    private  long refil_rate;
    private  Instant last_refil_time;
    private  int tokens;

    public TokenBucketRateLimiter(int bucket_size, long refil_rate){
        this.bucket_size = bucket_size;
        this.refil_rate = refil_rate;
        this.tokens = bucket_size;
        this.last_refil_time = Instant.now();
    }
    @Override
    public synchronized boolean allowRequest(String clientId) {
        Instant now = Instant.now();
        long millisElapsed = Duration.between(last_refil_time, now).toMillis();
        double tokensToAdd = (millisElapsed / 1000.0) * refil_rate;

        if (tokensToAdd > 0) {
            tokens = Math.min(bucket_size, tokens + (int) tokensToAdd);
            last_refil_time = now;
        }

        System.out.println("Tokens available: " + tokens);
        if (tokens >= 1) {
            tokens--;
            return true;
        }

        return false;
    }
}

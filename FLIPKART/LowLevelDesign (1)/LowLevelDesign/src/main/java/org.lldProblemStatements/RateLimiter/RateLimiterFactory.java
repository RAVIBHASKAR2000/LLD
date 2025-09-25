package main.java.org.lldProblemStatements.RateLimiter;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimiterType type, long windowSize, long requestPerWindowSize){
        switch(type){
            case FIXED_WINDOW:
                return new FixedWindowRateLimiter(requestPerWindowSize,windowSize);
            case SLIDING_WINDOW:
                return new SlidingWindowRateLimiter(requestPerWindowSize,windowSize);
            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter(1000,1,requestPerWindowSize);
            default:
                throw new IllegalArgumentException("Invalid type of Rate Limiter!");
        }
    }
}

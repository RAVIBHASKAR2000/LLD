public class RateLimiterFactory {

    public static RateLimiter createRateLimiter(String type , int maxRequests, long windowSizeinMillis){

        switch (type){
            case "fixed":
                return  new FixedWindowRateLimiter(maxRequests, windowSizeinMillis);
            case "sliding":
                return new SlidingWindowRateLimiter(maxRequests, windowSizeinMillis);
            case "tokenBucket":
                return  new TokenBucketRateLimiter(maxRequests, windowSizeinMillis);
            default:
                throw  new IllegalArgumentException("unknown rate limiter type");
        }

    }
}

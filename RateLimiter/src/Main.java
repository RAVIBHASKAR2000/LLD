public class Main {
    public static void main(String[] args) {


        RateLimiter fixedWindowRateLimiter = RateLimiterFactory.createRateLimiter("fixed", 10, 60000);
        RateLimiter slidingWindowRateLimiter = RateLimiterFactory.createRateLimiter("sliding", 10, 60000);

        RateLimiter tokenBucketRateLimiter = RateLimiterFactory.createRateLimiter("tokenBucket", 4, 2);
        // Testing Fixed Window Rate Limiter
        System.out.println("Fixed Window Rate Limiter:");
        for (int i = 0; i < 12; i++) {
            System.out.println(fixedWindowRateLimiter.allowRequest("client1"));
        }

        // Testing Sliding Window Rate Limiter
        System.out.println("Sliding Window Rate Limiter:");
        for (int i = 0; i < 12; i++) {
            System.out.println(slidingWindowRateLimiter.allowRequest("client2"));
        }



        System.out.println("token bucket Window Rate Limiter:");
        for (int i = 0; i < 12; i++) {
            System.out.println(tokenBucketRateLimiter.allowRequest("client3"));
        }
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        for (int i = 0; i < 12; i++) {
            System.out.println(tokenBucketRateLimiter.allowRequest("client3"));
        }

    }
}
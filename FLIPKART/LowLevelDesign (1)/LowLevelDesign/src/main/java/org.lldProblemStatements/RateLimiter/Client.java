package main.java.org.lldProblemStatements.RateLimiter;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // initialize both type of rate limiters
        RateLimiter fixedRateLimiter = RateLimiterFactory.createRateLimiter(RateLimiterType.FIXED_WINDOW,10,6000);
        // fixed window rate limiter
        RateLimiter slidingWindowRateLimiter = RateLimiterFactory.createRateLimiter(RateLimiterType.SLIDING_WINDOW,10,6000);
        // token bucket rate limiter
        RateLimiter tokenBucketRateLimiter = RateLimiterFactory.createRateLimiter(RateLimiterType.TOKEN_BUCKET,10,5);

        // sliding window rate limiter
//        fixedRateLimiter.allowRequest(new Request("asd123-123asca4-123123asfda","nutanix-interview/v1aloha1/test-rate-limiters",Request.Method.GET));

        for (int i = 0; i < 25; i++) {
            if (tokenBucketRateLimiter.allowRequest(new Request(Integer.toString(i),"test-enpoint/v1alpha1/token-bucket/"+i,Request.Method.GET))) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " rejected");
            }
            Thread.sleep(300);
        }
    }
}

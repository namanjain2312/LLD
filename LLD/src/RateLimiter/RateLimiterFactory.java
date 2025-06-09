package RateLimiter;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimiterType type, int capacity, long windowOrRefill) {
        switch (type) {
            case FIXED_WINDOW:
                return new FixedWindowRateLimiter(capacity, windowOrRefill);
            case SLIDING_WINDOW:
                return new SlidingWindowRateLimiter(capacity, windowOrRefill);
            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter(capacity, windowOrRefill);
            case LEAKY_BUCKET:
                return new LeakyBucketRateLimiter(capacity, windowOrRefill);
            default:
                throw new IllegalArgumentException("Unknown RateLimiterType: " + type);
        }
    }
}

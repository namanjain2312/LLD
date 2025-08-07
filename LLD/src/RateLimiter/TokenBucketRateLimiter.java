package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter  implements RateLimiter {
    private final int capacity;
    private final double refillRatePerMillis;
    private final ConcurrentHashMap<String, Bucket> userMap = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerMillis = refillRatePerSecond / 1000.0;
    }

    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userMap.putIfAbsent(userId, new Bucket(capacity, now));
        Bucket bucket = userMap.get(userId);

        synchronized (bucket) {
            long timeElapsed = now - bucket.lastRefillTimestamp;
            int tokensToAdd = (int)(timeElapsed * refillRatePerMillis);
            if(tokensToAdd > 0) {
                bucket.tokens = Math.min(capacity, bucket.tokens + tokensToAdd);
                bucket.lastRefillTimestamp += (long)(tokensToAdd/refillRatePerMillis);
            }

            if (bucket.tokens > 0) {
                bucket.tokens--;
                return true;
            } else {
                return false;
            }
        }
    }

    private static class Bucket {
        int tokens;
        long lastRefillTimestamp;

        Bucket(int tokens, long lastRefillTimestamp) {
            this.tokens = tokens;
            this.lastRefillTimestamp = lastRefillTimestamp;
        }
    }
}

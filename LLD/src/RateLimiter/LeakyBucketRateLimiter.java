package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;

public class LeakyBucketRateLimiter implements  RateLimiter{

    private final int capacity;//Capacity of Bucket
    private final long leakIntervalMillis;//leak interval of let say 1000ms
    private final ConcurrentHashMap<String, Bucket> userBuckets = new ConcurrentHashMap<>();

    public LeakyBucketRateLimiter(int capacity, long leakIntervalMillis) {
        this.capacity = capacity;
        this.leakIntervalMillis = leakIntervalMillis;
    }

    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userBuckets.putIfAbsent(userId, new Bucket(0, now));
        Bucket bucket = userBuckets.get(userId);

        synchronized (bucket) {
            long leaked = (now - bucket.lastLeakTimestamp) / leakIntervalMillis;
            if (leaked > 0) {
                bucket.content = Math.max(0, bucket.content - (int) leaked);
                bucket.lastLeakTimestamp += leaked * leakIntervalMillis;
            }

            if (bucket.content < capacity) {
                bucket.content++;
                return true;
            } else {
                return false;
            }
        }
    }

    private static class Bucket {
        int content;
        long lastLeakTimestamp;

        Bucket(int content, long lastLeakTimestamp) {
            this.content = content;
            this.lastLeakTimestamp = lastLeakTimestamp;
        }
    }

}

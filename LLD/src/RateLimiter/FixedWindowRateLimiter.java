package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final ConcurrentHashMap<String, UserRequestInfo> userMap = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        userMap.putIfAbsent(userId, new UserRequestInfo(currentTime));
        UserRequestInfo info = userMap.get(userId);

        synchronized (info) {
            if (currentTime - info.windowStart >= windowSizeInMillis) {
                info.windowStart = currentTime;
                info.requestCount.set(0);
            }

            if (info.requestCount.incrementAndGet() <= maxRequests)
                return true;
            else
                return false;
        }
    }

    private static class UserRequestInfo {
        long windowStart;
        AtomicInteger requestCount;

        UserRequestInfo(long windowStart) {
            this.windowStart = windowStart;
            this.requestCount = new AtomicInteger(0);
        }
    }
}

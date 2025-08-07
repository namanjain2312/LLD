package RateLimiter;

import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowRateLimiter implements  RateLimiter{
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final ConcurrentHashMap<String, ConcurrentLinkedDeque<Long>> userMap = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        userMap.putIfAbsent(userId, new ConcurrentLinkedDeque<>());
        ConcurrentLinkedDeque<Long> queue = userMap.get(userId);

        synchronized (queue) {
            while (!queue.isEmpty() && now - queue.peekFirst() > windowSizeInMillis) {
                queue.pollFirst();
            }

            if (queue.size() < maxRequests) {
                queue.offerLast(now);
                return true;
            } else {
                return false;
            }
        }
    }
}

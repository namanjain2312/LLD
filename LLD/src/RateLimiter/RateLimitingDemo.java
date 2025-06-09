package RateLimiter;

public class RateLimitingDemo {
    public static void main(String[] args) {
        RateLimiter fixed = RateLimiterFactory.createRateLimiter(RateLimiterType.FIXED_WINDOW, 3, 5000);
        RateLimiter sliding = RateLimiterFactory.createRateLimiter(RateLimiterType.SLIDING_WINDOW, 3, 5000);
        RateLimiter token = RateLimiterFactory.createRateLimiter(RateLimiterType.TOKEN_BUCKET, 3, 1);
        RateLimiter leaky = RateLimiterFactory.createRateLimiter(RateLimiterType.LEAKY_BUCKET, 3, 1000);

        Runnable task = () -> {
            String userId = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println("[Fixed] " + userId + ": " + (fixed.allowRequest(userId) ? "Allowed" : "Blocked"));
                System.out.println("[Sliding] " + userId + ": " + (sliding.allowRequest(userId) ? "Allowed" : "Blocked"));
                System.out.println("[Token] " + userId + ": " + (token.allowRequest(userId) ? "Allowed" : "Blocked"));
                System.out.println("[Leaky] " + userId + ": " + (leaky.allowRequest(userId) ? "Allowed" : "Blocked"));
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(task, "user" + i).start();
        }
    }
}

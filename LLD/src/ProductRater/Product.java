package ProductRater;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Product {
    private final String productId;
    private final String name;
    // userId -> Rating
    private final Map<String, Rating> ratingMap;
    private int totalRatingValue = 0;
    private int totalRatingCount = 0;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
        this.ratingMap =  new ConcurrentHashMap<>();
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }

    public void addOrUpdateRating(Rating rating) {
        String userId = rating.getUser().getUserId();

        synchronized (this) {
            if (ratingMap.containsKey(userId)) {
                // Update existing rating
                Rating existingRating = ratingMap.get(userId);
                totalRatingValue -= existingRating.getRatingValue();
            } else {
                // New rating
                totalRatingCount++;
            }

            ratingMap.put(userId, rating);
            totalRatingValue += rating.getRatingValue();
        }
    }

    public double getAverageRating() {

        synchronized (this) {
            if (totalRatingCount == 0) return 0.0;
            return (double) totalRatingValue / totalRatingCount;
        }
    }

    public Rating getUserRating(String userId) {
        return ratingMap.get(userId);
    }

    public boolean removeRatingByUser(String userId) {
        Rating removed = ratingMap.remove(userId);
        if (removed != null) {
            totalRatingValue -= removed.getRatingValue();
            totalRatingCount--;
            return true;
        }
        return false;
    }
}

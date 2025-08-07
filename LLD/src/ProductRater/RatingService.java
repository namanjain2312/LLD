package ProductRater;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RatingService {
    private final Map<String, Product> productMap = new ConcurrentHashMap<>();
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public void rateProduct(String userId, String productId, int ratingValue) {
        User user = userMap.get(userId);
        Product product = productMap.get(productId);

        if (user == null || product == null) {
            throw new IllegalArgumentException("Invalid user or product");
        }

        Rating rating = new Rating(user, product, ratingValue);
        product.addOrUpdateRating(rating);
    }

    public double getAverageRating(String productId) {
        Product product = productMap.get(productId);
        if (product == null) return 0.0;
        return product.getAverageRating();
    }

    public List<Product> getTopKProductsByRating(int k) {
        PriorityQueue<Product> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getAverageRating(), b.getAverageRating())  // min-heap
        );

        for (Product product : productMap.values()) {
            pq.offer(product);
            if (pq.size() > k) {
                pq.poll(); // Remove lowest rated product
            }
        }

        List<Product> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll()); // Add in reverse to make it descending
        }
        return result;
    }

    public Rating getUserRating(String userId, String productId) {
        Product product = productMap.get(productId);
        if (product == null) return null;
        return product.getUserRating(userId);
    }



}

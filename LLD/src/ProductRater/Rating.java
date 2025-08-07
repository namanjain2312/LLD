package ProductRater;

public class Rating {
    private final User user;
    private final Product product;
    private final int ratingValue; // 1 to 5

    public Rating(User user, Product product, int ratingValue) {
        if (ratingValue < 1 || ratingValue > 5) {
            throw new IllegalArgumentException("Rating must be 1 to 5");
        }
        this.user = user;
        this.product = product;
        this.ratingValue = ratingValue;
    }

    public User getUser() { return user; }
    public Product getProduct() { return product; }
    public int getRatingValue() { return ratingValue; }

}

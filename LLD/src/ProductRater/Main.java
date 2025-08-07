package ProductRater;

public class Main {
    public static void main(String[] args) {
        RatingService service = new RatingService();

        User u1 = new User("u1", "Alice");
        User u2 = new User("u2", "Bob");
        service.addUser(u1);
        service.addUser(u2);

        Product p1 = new Product("p1", "iPhone");
        Product p2 = new Product("p2", "Samsung");
        Product p3 = new Product("p3", "OnePlus");

        service.addProduct(p1);
        service.addProduct(p2);
        service.addProduct(p3);

        service.rateProduct("u1", "p1", 4); // iPhone
        service.rateProduct("u2", "p1", 5);

        service.rateProduct("u1", "p2", 5); // Samsung
        service.rateProduct("u2", "p2", 5);

        service.rateProduct("u1", "p3", 3); // OnePlus
        service.rateProduct("u2", "p3", 3);

        System.out.println("Average rating iPhone: " + service.getAverageRating("p1")); // 4.5
        System.out.println("Average rating Samsung: " + service.getAverageRating("p2")); // 5.0
        System.out.println("Average rating OnePlus: " + service.getAverageRating("p3")); // 3.0

        System.out.println("Highest rated product rating: " + service.getTopKProductsByRating(1).get(0).getAverageRating());
        System.out.println("Highest rated product name: " + service.getTopKProductsByRating(1).get(0).getName());
    }
}

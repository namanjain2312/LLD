package ProductRater;

public class Main {

    public static void main(String[] args) {

        ProductRaterController productRaterController = new ProductRaterController();
        productRaterController.CreateRatingForProductId("1",10,0,"Rating1");
        productRaterController.AssignRating("1",5,"Naman");
        productRaterController.AssignRating("1",10,"Rahul");
        productRaterController.AssignRating("1",11,"Mayank");

        productRaterController.GetAllRatingForProductId("1");


    }
}

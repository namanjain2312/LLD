package ProductRater;

import javax.sound.midi.SysexMessage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductRaterController {

    ///product id vs there rating type
    ConcurrentHashMap<String,Rating> productIdVsRating;
    ///productId , userId vs there rating
    ConcurrentHashMap<String,ConcurrentHashMap<String,Integer>> productAndUserIdRating;

    ProductRaterController()
    {
        productAndUserIdRating = new ConcurrentHashMap<>();
        productIdVsRating = new ConcurrentHashMap<>();
    }

    public boolean CreateRatingForProductId(String productId,int maxRating,int minRating,String ratingDescription)
    {
        if(productIdVsRating.containsKey(productId)){
            System.out.println("Cannot change the existing rating type for a product");
            return false;
        }
        Rating rating = new Rating(minRating,maxRating,ratingDescription);
        productIdVsRating.put(productId,rating);
        return true;
    }

    public boolean AssignRating(String productId,int ratingPoints,String userId)
    {
        if(!ValidateRating(productId,ratingPoints))
            return false;

        productAndUserIdRating.putIfAbsent(productId,new ConcurrentHashMap<>());

        productAndUserIdRating.get(productId).put(userId,ratingPoints);
        return true;
    }

    public boolean ValidateRating(String productId,int ratingPoints)
    {
        Rating rating = productIdVsRating.get(productId);
        if(ratingPoints>rating.getMaxRating() || ratingPoints<rating.getMinRating()){
            System.out.println("Invalid Rating");
            return false;
        }
        return true;
    }

    public void GetAllRatingForProductId(String productId)
    {
        int totalUserCount=0;
        int averageRating=0;
        int totalRatingPoints=0;
        int maxRatingPoints=0;

        for(Map.Entry<String,Integer> entry : productAndUserIdRating.get(productId).entrySet())
        {
            totalUserCount++;
            totalRatingPoints += entry.getValue();
        }
        maxRatingPoints = productIdVsRating.get(productId).getMaxRating() * totalUserCount;

        System.out.println("Total User Which Have Given the Rating are - " + totalUserCount);
        System.out.println("Max Rating points : " + maxRatingPoints);
        System.out.println("Total Rating Point recieved : " + totalRatingPoints);
        System.out.println("Average Rating of the product is " + ((double)totalRatingPoints/maxRatingPoints) * (double)productIdVsRating.get(productId).getMaxRating());
    }
}

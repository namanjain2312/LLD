package ProductRater;

public class Rating {

    private int minRating;
    private int maxRating;
    private String description;

    Rating(int minRating,int maxRating,String description)
    {
        this.minRating = minRating;
        this.maxRating = maxRating;
        this.description = description;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
    }

    public int getMinRating() {
        return minRating;
    }

    public void setMinRating(int minRating) {
        this.minRating = minRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

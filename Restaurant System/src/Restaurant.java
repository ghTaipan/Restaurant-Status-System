public class Restaurant {
    private String name;
    private double rating;
    private String cuisine;
    private int deliveryTime; // in minutes
    public void updateCuisine(String category){
        cuisine = category;
    }
    public void updateRating(double score){
        rating = score;
    }
    public void updateDeliveryTime(int deliveryTime){
        this.deliveryTime = deliveryTime;
    }

    public Restaurant(String name, double rating, String cuisine, int deliveryTime) {
        this.name = name;
        this.rating = rating;
        this.cuisine = cuisine;
        this.deliveryTime = deliveryTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public String toString(){
        return name+","+rating+","+cuisine+","+deliveryTime;
    }
}

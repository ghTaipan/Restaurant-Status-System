import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BST<Food> priceBST = new BST<Food>(1);
        Methods.createAll(priceBST, 1);
        BST<Food> stockBST = new BST<Food>(2);
        Methods.createAll(stockBST, 2);
        BST<Restaurant> ratingBST = new BST<Restaurant>(4);
        Methods.createAll(ratingBST, 4);
        BST<Restaurant> deliveryTimeBST = new BST<Restaurant>(6);
        Methods.createAll(deliveryTimeBST, 6);
        Methods.outputs(priceBST, stockBST, ratingBST, deliveryTimeBST);

    }
}

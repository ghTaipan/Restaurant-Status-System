public class Methods{
    public static void createFood(BST bst, int order, int i,Restaurant r) {

        String fname = "";
        double fPrice = 0;
        int fStock = 0;
        FileIO val = new FileIO();
        for (String j : val.readValues("datas.csv")[i]) {
            if (j.equals(val.readValues("datas.csv")[i][0])) {
                fname = j;
            } else if (j.equals(val.readValues("datas.csv")[i][1])) {
                fPrice = Double.parseDouble(j);
            } else if (j.equals(val.readValues("datas.csv")[i][2])) {
                fStock = Integer.parseInt(j);

            }

        }
        Food food = new Food(fname, fPrice, fStock, r);
        if (order<3)
            bst.add(food);
    }
    public static Object createRestaurant(BST bst,int order, int i) {

        String rName = "";
        double rRating = 0;
        String rCuisine = "";
        int rDelivery = 0;
        FileIO val = new FileIO();
        for (String j : val.readValues("datas.csv")[i]) {
            if (j.equals(val.readValues("datas.csv")[i][3])) {
                rName = j;
            } else if (j.equals(val.readValues("datas.csv")[i][4])) {
                rRating = Double.parseDouble(j);
            } else if (j.equals(val.readValues("datas.csv")[i][5])) {
                rCuisine = j;
            } else if (j.equals(val.readValues("datas.csv")[i][6])) {
                rDelivery = Integer.parseInt(j);
            }
        }
        Restaurant restaurant = new Restaurant(rName, rRating, rCuisine, rDelivery);
        if(order>3)
            bst.add(restaurant);
        return restaurant;
    }
    public static void createAll(BST bst,int order) {
        Restaurant a = (Restaurant) Methods.createRestaurant(bst,order, 1);
        for (int i = 1; i < 3; i++) {
            Methods.createFood(bst, order, i, a);
        }
        Restaurant b = (Restaurant) Methods.createRestaurant(bst,order,3);
        for (int i = 3; i < 5; i++) {
            Methods.createFood(bst, order, i, b);
        }
        Restaurant c = (Restaurant) Methods.createRestaurant(bst,order,5);
        for (int i = 5; i < 8; i++) {
            Methods.createFood(bst, order, i, c);
        }
        Restaurant d = (Restaurant) Methods.createRestaurant(bst,order,8);
        for (int i = 8; i < 11; i++) {
            Methods.createFood(bst, order, i, d);
        }
        Restaurant e = (Restaurant) Methods.createRestaurant(bst,order,11);
        for (int i = 11; i < 13; i++) {
            Methods.createFood(bst, order, i, e);
        }
        Restaurant f = (Restaurant) Methods.createRestaurant(bst,order,13);
        for (int i = 13; i < 16; i++) {
            Methods.createFood(bst, order, i, f);
        }
        Restaurant g = (Restaurant) Methods.createRestaurant(bst,order,16);
        for (int i = 16; i < 19; i++) {
            Methods.createFood(bst, order, i, g);
        }
        Restaurant h = (Restaurant) Methods.createRestaurant(bst,order,19);
        for (int i = 19; i < 21; i++) {
            Methods.createFood(bst, order, i, h);
        }
    }
    public static double truncateDecimals(double d, int len) {
        long p = pow(10, len);
        long l = (long)(d * p);
        return (double)l / (double)p;
    }

    public static long pow(long a, int b) {
        long result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }
    public static void outputs( BST<Food> priceBST, BST<Food> stockBST, BST<Restaurant> ratingBST, BST<Restaurant> deliveryTimeBST){
        //STEP1
        System.out.println("------------------ 1 ------------------");
        ratingBST.DescendingInOrder();
        for (int i = 0; i < ratingBST.countNodes(); i++) {
            Restaurant x = (Restaurant) ratingBST.stack.pop();
            String y = ("");
            for (int j = 0; j < (35 - x.getName().length()); j++) {
                y = y + " ";
            }
            System.out.println(x.getName() + y + x.getRating());
        }
        ratingBST.stack.clear();
        //STEP2
        System.out.println("\n------------------ 2 ------------------");
        priceBST.AscendingInOrder();
        for (int i = 0; i < priceBST.countNodes(); i++) {
            Food x = (Food) priceBST.stack.pop();
            String y = ("");
            for (int j = 0; j < (24 - x.getName().length()); j++) {
                y = y + " ";
            }
            String z = " " + x.getName() + y + x.getPrice();
            y = "";
            for (int k = 0; k < (35 - z.length()); k++) {
                y = y + " ";
            }
            System.out.println(z + y + x.getStock());
        }
        priceBST.stack.clear();
        //STEP3
        System.out.println("\n------------------ 3 ------------------");
        deliveryTimeBST.AscendingInOrder();
        for (int i = 0; i < deliveryTimeBST.countNodes(); i++) {
            ;
            Restaurant x = (Restaurant) deliveryTimeBST.stack.pop();
            String y = "";
            for (int j = 0; j < (35 - x.getName().length()); j++) {
                y = y + " ";
            }
            if (x.getCuisine().equals(" Pizza")) {
                System.out.println(x.getName() + y + x.getDeliveryTime());
                break;
            }
        }
        deliveryTimeBST.stack.clear();
        //STEP4
        System.out.println("\n------------------ 4 ------------------");
        stockBST.DescendingInOrder();
        for (int i = 0; i < stockBST.countNodes(); i++) {
            Food x = (Food) stockBST.stack.pop();
            String y = "";
            for (int j = 0; j < (34 - x.getName().length()); j++) {
                y = y + " ";
            }
            if (x.getRestaurant().getCuisine().equals(" Coffee")) {
                System.out.println(" " + x.getName() + y + x.getStock());
                break;
            }
        }
        stockBST.stack.clear();
        //STEP5
        System.out.println("\n------------------ 5 ------------------");
        priceBST.DescendingInOrder();
        for (int i = 0; i < priceBST.countNodes(); i++) {
            Food x = (Food) priceBST.stack.pop();
            String y = "";
            for (int j = 0; j < (22 - x.getName().length()); j++) {
                y = y + " ";
            }
            String z = " " + x.getName() + y + x.getPrice();
            y = "";
            for (int k = 0; k < (31 - z.length()); k++) {
                y = y + " ";
            }
            if(x.getPrice()>80) {
                System.out.println(z + y + "removed");
                priceBST.delete(x);
                stockBST.delete(x);
            }
        }
        priceBST.stack.clear();
        //STEP6
        System.out.println("\n------------------ 6 ------------------");
        ratingBST.AscendingInOrder();
        for (int i = 0; i < ratingBST.countNodes(); i++) {
            Restaurant x = (Restaurant) ratingBST.stack.pop();
            String y = "";
            for (int j = 0; j < (22 - x.getName().length()); j++) {
                y = y + " ";
            }
            String z = " " + x.getName() + y + x.getRating();
            y = "";
            for (int k = 0; k < (31 - z.length()); k++) {
                y = y + " ";
            }
            if(x.getRating()<8) {
                System.out.println(z + y + "removed");
                ratingBST.delete(x);
                deliveryTimeBST.delete(x);
            }
        }
        ratingBST.stack.clear();
        //STEP7
        System.out.println("\n------------------ 7 ------------------");
        priceBST.DescendingInOrder();
        for (nodeBST<Food> i: priceBST.alist.toArray()){
            i.getValue().updatePrice((i.getValue().getPrice()*120)/100);
        }
        priceBST.stack.clear();
        stockBST.DescendingInOrder();
        for (nodeBST<Food> i : stockBST.alist.toArray()){
            i.getValue().updatePrice((i.getValue().getPrice()*120/100));
        }
        priceBST.stack.clear();
        stockBST.stack.clear();
        System.out.println("    Prices in FoodBSTs are updated.");
        //STEP8
        System.out.println("\n------------------ 8 ------------------");
        priceBST.DescendingInOrder();
        for (nodeBST<Food> i: priceBST.alist.toArray()){
            i.getValue().updateStock((i.getValue().getStock()/2));
        }
        priceBST.stack.clear();
        stockBST.DescendingInOrder();
        for (nodeBST<Food> i : stockBST.alist.toArray()){
            i.getValue().updateStock((i.getValue().getStock()/2));
        }
        stockBST.stack.clear();
        System.out.println("    Stocks in FoodBSTs are updated.");
        //STEP9
        System.out.println("------------------ 9 ------------------");
        ratingBST.DescendingInOrder();
        for (int i = 0; i < ratingBST.countNodes(); i++) {
            Restaurant x = (Restaurant) ratingBST.stack.pop();
            String y = ("");
            for (int j = 0; j < (35 - x.getName().length()); j++) {
                y = y + " ";
            }
            System.out.println(x.getName() + y + x.getRating());
        }
        ratingBST.stack.clear();
        //STEP2
        System.out.println("\n------------------ 10 ------------------");
        priceBST.AscendingInOrder();
        for (int i = 0; i < priceBST.countNodes(); i++) {
            Food x = (Food) priceBST.stack.pop();
            double a = Methods.truncateDecimals(x.getPrice(),2);
            String y = ("");

            for (int j = 0; j < (24 - x.getName().length()); j++) {
                y = y + " ";
            }
            String z = " " + x.getName() + y + a;
            y = "";
            for (int k = 0; k < (35 - z.length()); k++) {
                y = y + " ";
            }
            System.out.println(z + y + x.getStock());
        }
        priceBST.stack.clear();
        System.out.println("----------------------------------------");
        priceBST.preorder();
        for (int i = 0; i < priceBST.countNodes(); i++) {
            Food x = (Food) priceBST.stack.pop();
            double a = Methods.truncateDecimals(x.getPrice(),2);
            String y = ("");

            for (int j = 0; j < (24 - x.getName().length()); j++) {
                y = y + " ";
            }
            String z = " " + x.getName() + y + a;
            y = "";
            for (int k = 0; k < (35 - z.length()); k++) {
                y = y + " ";
            }
            System.out.println(z + y + x.getStock());
        }
        priceBST.stack.clear();
        System.out.println("----------------------------------------");
    }
}

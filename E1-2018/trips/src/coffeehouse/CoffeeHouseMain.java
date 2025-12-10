package src.coffeehouse;

public class CoffeeHouseMain {
    public static void main(String[] args) {

        String[] orders = {
            "coffee",
            "coffee, extras",
            "tea",
            "tea, extras"
        };

        for (String order : orders) {
            Beverage b = Barista.takeOrder(order);
            if (b != null) {
                b.prepareRecipe();   
            }
        }
    }
}


package src.coffeehouse;

public class Barista {
    static public Beverage takeOrder(String order){
        switch (order) {
            case "coffee":
                return new Coffee(false);
            case "coffee, extras":
                return new Coffee(true);
            case "tea":
                return new Tea(false);
            case "tea, extras":
                return new Tea(true);
            default:
                return null;
        }
    }
}

package coffeehouse;

public class Barista {
    public Beverage takeOrder(String order){
        if(order.equals("coffee")){
            return new Coffee(false);
        }
        else if(order.equals("coffee, extras")){
            return new Coffee(true);
        }
        else if (order.equals("tea")) {
            return new Tea(false);
        }
        else if(order.equals("tea, extras")){
            return new Tea(true);
        }
        
        return null;
    }
}

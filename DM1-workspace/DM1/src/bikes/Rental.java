package bikes;

import java.util.Locale;

public class Rental {
    private double distance;
    private String user;
    private Bike bike;

    public Rental(Bike bike, String user, double dist){
        this.distance = dist;   
        this.user = user;
        this.bike = bike;
        bike.addRental(this);
    }

    public String toString(){
        return "Rent " + this.bike.getId() + " to " + this.user + " for " + String.format(Locale.US,"%.2f",this.distance) + " km";
    }

    public double getDistance(){
        return this.distance;
    }
}

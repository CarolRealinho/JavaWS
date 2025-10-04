package bikes;

import java.util.ArrayList;
import java.util.Locale;

public class Bike {
    private String id;
    private double totalDistance;
    private ArrayList<Rental> rentals;

    /**
     * Constructor
     */
    public Bike(String id){
        this.id = id;
        this.totalDistance = 0;
        this.rentals = new ArrayList<>();
    }

    public String toString(){
        return this.id + "(" + String.format(Locale.US, "%.2f",this.totalDistance) + " km)";
    }

    public String getId(){
        return this.id;
    }

    public double getTotalDistance(){
        return this.totalDistance;
    }

    public ArrayList<Rental> getRentals(){
        return this.rentals;  
    }

    public void addRental(Rental rental){
        rentals.add(rental);
        this.totalDistance = this.totalDistance + rental.getDistance();
    }

}

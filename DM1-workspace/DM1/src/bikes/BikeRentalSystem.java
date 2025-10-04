package bikes;

import java.util.ArrayList;
import java.util.TreeMap;

public class BikeRentalSystem {
    private TreeMap<String,Bike> bikes;
    private ArrayList<Rental> rentals;

    public BikeRentalSystem(){
        bikes = new TreeMap<String,Bike>(); // TreeMap to order
        rentals = new ArrayList<Rental>();
    }

    public void addBike(String id){
        int flag = 0;
        for(String key: bikes.keySet()){   // manual loop probably not efficient
            if (key.contentEquals(id)){
                System.out.println("The bike is already stored");
                flag = 1;
            }
        }
        if (flag == 0){
            Bike bikeNew = new Bike(id);
            bikes.put(id,bikeNew);
        }
    }

    public void recordRental(String id, String user, double dist){
        int flag = 0;
        for(String key: bikes.keySet()){   // manual loop probably not efficient
            if (key.contentEquals(id)){
                Rental rentalNew = new Rental(bikes.get(id), user, dist); 
                rentals.add(rentalNew);
                flag = 1;
            }
        }
        if (flag==0){
            System.out.println("Bike not stored");
        }
    }

    // prints are never in the correct form and Locale.US never really worked...
    public void showAll(){
        for(Bike b: bikes.values()){
            System.out.println(b);
        }
        for(Rental r: rentals){
            System.out.println(r);
        } 
    }

}

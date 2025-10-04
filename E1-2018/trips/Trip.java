package trips;

import java.util.ArrayList;

public class Trip {
    private ArrayList<Flight> flights;

    public Trip(){
        this.flights = new ArrayList<Flight>();
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public String toString(){
        if (this.flights.size() == 0){
            return "No flights yet";
        }
        else if (this.flights.size() == 1){
            return this.flights.get(0).toString() + " (direct)";
        }
        return this.flights.get(0).getDepartureAirport().getIata() + " - " + this.flights.get(this.flights.size()-1).getArrivalAirport().getIata() + " (" + this.flights.size() + " flights)";
    }

    public boolean isValid(){
        for(int f=0;f < flights.size()-1;f++){
            if(flights.get(f).isConnectedTo(flights.get(f+1))==false){
                return false;
            }
        }
        return true;
    }

}

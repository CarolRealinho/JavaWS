package trips;

public class Flight {
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;

    public Flight(String num, Airport depAirport, Airport arrAirport){
        this.flightNumber=num;
        this.arrivalAirport= arrAirport;
        this.departureAirport= depAirport;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public Airport getDepartureAirport(){
        return this.departureAirport;
    }

    public Airport getArrivalAirport(){
        return this.arrivalAirport;
    }

    public String toString(){
        return this.flightNumber + " : " + this.departureAirport + " - " + this.arrivalAirport;
    }

    public boolean isConnectedTo(Flight next){
        return next.departureAirport.getIata().equals(this.arrivalAirport.getIata());
    }
}

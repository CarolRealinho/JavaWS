package trips;

public class TripMain {
    public static void main(String[] args) {
        Airport tls = new Airport("Toulouse Blagnac", "TLS");
        Airport lsb = new Airport("Lisbon", "LS");
        System.out.println(tls);

        Flight f1 = new Flight("2", tls, lsb);
        System.out.println(f1);
    }

    
    
}

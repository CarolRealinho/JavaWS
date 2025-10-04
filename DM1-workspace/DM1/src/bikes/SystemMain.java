package bikes;

public class SystemMain {
    public static void main(String[] args) {
        BikeRentalSystem bike3000 = new BikeRentalSystem();

        bike3000.addBike("B1");
        bike3000.addBike("B2");

        bike3000.recordRental("B1", "Alice", 10.0);
        bike3000.recordRental("B2", "Alice", 20.0);
        bike3000.recordRental("B2", "Bob", 100.0);

        bike3000.showAll();
    }
}

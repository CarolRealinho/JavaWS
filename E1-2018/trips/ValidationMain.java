package trips;

public class ValidationMain {
    public static void main(String[] args) {
        Airport a1 = new Airport("mimi", "mimimi");
        Airport a2 = new Airport("lalala", "lala");
        Airport a3 = new Airport("trelele", "trelee");

        Flight f1 = new Flight("a21", a1, a2);
        Flight f2 = new Flight("dedf", a2, a3);

        Trip t = new Trip();
        t.addFlight(f2);
        t.addFlight(f1);

        System.out.println(t.isValid());
    }
}

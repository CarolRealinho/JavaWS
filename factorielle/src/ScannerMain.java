import java.util.Locale;
import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) {
        var con = System.console();

        if (con != null) {
            Scanner sc = new Scanner(con.reader()).useLocale(Locale.US);
            System.out.print("Insert an integer: ");
            int i = sc.nextInt();
            System.out.print("Insert a double: ");
            double r = sc.nextDouble();
            System.out.print("Insert true or false (testing mode on or off): ");
            boolean testing = sc.nextBoolean();
            System.out.printf(Locale.US, "Numbers read in the console: %d and %f.%nTesting mode %b.%n", i, r,testing);
            sc.close();
        }
    }
}

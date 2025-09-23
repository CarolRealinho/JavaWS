import java.util.Locale;

public class PrintMain {
public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    boolean ok = true;
    System.out.printf("ok is %b%n",ok);

    int k = 7;
    System.out.print(k); // prints 7 and stays on the current line
    System.out.println(k + k); // prints 14 next to the 7 and opens a new line

    int nbDwarfs = 7;
    System.out.println("Blanche-Neige et les " + nbDwarfs + " nains"); // using +

    int n = 7;
    System.out.printf("Blanche-Neige et les %d nains%n", n); // 2 arguments to printf
    System.out.printf("%d * 0.5 = %f%n", n, n * 0.5); // 3 arguments to printf
}
}

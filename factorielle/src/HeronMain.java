public class HeronMain {
public static void main(String[] args) {
    int n = 2; // order of the root
    int k = 5; // order of approximation
    int A = 2; // number to take the root of

    double racine=1; // initial guess
    int i = 0;       // iteration counter
    
    while (i<k){
        racine = 1.0/n*((n-1)*racine+A/Math.pow(racine, n-1)); // use 1.0/n instead of 1/n
        i++;
    }

    System.out.print("\nThe root " + n + " of order " + k + " of " + A + " is equal to " + racine);
}
}

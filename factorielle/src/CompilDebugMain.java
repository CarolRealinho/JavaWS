public class CompilDebugMain {
public static void main(String[] args) {
    // Compute the Euclidean length of a 3D vector
    double x = 1;
    double y = 1;
    double z = 1; // if this was named x we would have an error of duplicate local variable
    double norm = 0; // this variable was not being used - we can either comment/remove it or use it
    // The method sqr(double) is undefined for the type Math - typo
    norm = Math.sqrt(x*x + y*y + z*z);
    System.out.println("norm = " + norm); // if we haven't defined z it could not be "resolved to a variable"
}
}

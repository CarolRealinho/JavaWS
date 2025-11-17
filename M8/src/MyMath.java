public class MyMath {
    private static final double EPSILON = 1e-10;

    public static double sqrt(double x) throws IllegalArgumentException, ArithmeticException{
        if(x<0){
            throw new IllegalArgumentException();
        }

        double y = x; // initial guess
        for (int i = 0; i < 20; i++) {
            y = 0.5 * (y + x / y); // Newton iteration
        }

        if (y < 0 || Math.abs((x - y * y) / x) > EPSILON) {
            throw new ArithmeticException("Postcondition failed");
        }

        return y;
    }
}
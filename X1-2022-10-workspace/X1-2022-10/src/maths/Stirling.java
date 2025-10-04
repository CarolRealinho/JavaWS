package maths;

public class Stirling {
    public static double factorial(int n){
        double f1 = Math.sqrt(2*Math.PI*n);
        double f2= Math.pow(n/Math.E, n);
        double f3 = 1.0+1.0/(12.0*n);
        return f1*f2*f3;
    }
}

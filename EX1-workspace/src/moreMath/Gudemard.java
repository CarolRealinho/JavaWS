package moreMath;

public class Gudemard{

    // gd(x) = atan(sinh(x))
    static public double gd(double x) {
        return Math.atan(Math.sinh(x));
    }

    // arcgd(x) = artanh(sin(x)) = 0.5 * ln((1 + sin(x)) / (1 - sin(x)))
    static public double arcgd(double x) {
        if (x > -Math.PI / 2 && x < Math.PI / 2) {
            double s = Math.sin(x);
            return 0.5 * Math.log((1 + s) / (1 - s));
        }
        return Double.NaN;
    } 

    // alternative forms
    static public double arcgdV2(double x){
        if(x>-Math.PI/2 && x<Math.PI/2){
            return Math.log(Math.tan(x)+1/Math.cos(x));
        }
        return Double.NaN;
    }

    static public double arcgdV3(double x){
        if(x> -Math.PI/2 && x< Math.PI/2){
            return Math.log(Math.tan(x/2+Math.PI/4));
        }
        return Double.NaN;
    }

    // helper for sign
    private static double signe(double theta){
        return (theta<0) ? -1.0 : 1.0;
    }
}
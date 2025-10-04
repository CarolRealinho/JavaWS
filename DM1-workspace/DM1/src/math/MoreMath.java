package math;

// why is the last test wrong???

public class MoreMath {
    /**
     * Calculate the inverse hyperbolic sine of x
     * 
     * @param x
     * @return
     */
    static public double asinh(double x){   // static public or public static
        return Math.log( x +Math.sqrt( Math.pow(x,2)+1));
    }
    
    /**
     * Calculate the inverse hyperbolic cosine of x
     * 
     * @param x
     * @return
     */
    static public double acosh(double x){
        double result = Double.NaN;
        if (x>=1){
            result = Math.log( x + Math.sqrt(Math.pow(x,2)-1));
        }
        return result;
    }
}

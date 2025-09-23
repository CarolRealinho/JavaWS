public class LeibnizMain {
public static void main(String[] args) {
    int n = 2; // number of series iterations
    double piSeries = 0;

    for(int i=0;i<=n;i++){
        //piSeries = piSeries + (Math.pow(-1, i))/(2*i+1);
        int sign = (i%2 == 0) ? 1:-1;               // Alternative to avoid Math
        piSeries = piSeries + sign/(double)(2*i+1); // Convert denominator to double
    }

    piSeries = 4*piSeries;
    System.out.print("The value of pi after " + n + " iterations is " + piSeries);
}
}

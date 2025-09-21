public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Dummy World!");

        //RGB rgb1 = new RGB(0.2, 0.5, 0.7);
        //RGB rgb2 = new RGB(0, 0, 0);
        //RGB rgb3 = new RGB(1, 1, 1);
        //RGB rgb4 = new RGB(-4, 0, 0);
        //RGB rgb5 = new RGB(0, 1.2, 0);
        RGB rgb6 = new RGB(0, 0, 8.1);

        System.out.println(rgb6.hasValuesInRange());
        System.out.println(Double.MAX_VALUE);

        // exercice 1.
        double a=3;
        double b=4;

        System.out.println(Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)));

        // exercice 2.
        double r=1;
        System.out.println(2*r*Math.PI);

        // exercice 3.
        double latBrest = Math.toRadians(48.400002); 
        double latToul = Math.toRadians(43.599998);
        double lonBrest = Math.toRadians(4.48333);
        double lonToul = Math.toRadians(1.43333);
        double R = 6378*10^3; // rayon de la Terre [m]

        System.out.println("Distance = " + R*Math.acos(Math.cos(latBrest)*Math.cos(latToul)*Math.cos(lonBrest-lonToul)+Math.sin(latBrest)*Math.sin(latToul)));

        System.out.printf("Is 0.5 in range? %b%n", RGB.isValueInRange(0.5));
    }
}

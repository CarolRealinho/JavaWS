public class RGBEqualsMain {
public static void main(String[] args) {
    RGB rgb1 = new RGB(0, 0, 0);
    RGB rgb2 = rgb1;
    RGB rgb3 = new RGB(0.5,0.4,0.25);
    RGB rgb4 = new RGB(0.5,0.4,0.25);
    RGB rgb5=null;

    System.out.printf("Is rgb1 equal to rgb2? %b%n", rgb1.equals(rgb2));
    System.out.printf("Is rgb3 equal to rgb4? %b%n", rgb3.equals(rgb4));
    System.out.printf("Is rgb5 equal to rgb1? %b%n", rgb1.equals(rgb5));
    System.out.printf("Is rgb3 equal to rgb2? %b%n", rgb3.equals(rgb2));
}
}

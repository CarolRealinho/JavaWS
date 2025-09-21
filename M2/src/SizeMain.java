public class SizeMain {
public static void main(String[] args) {
    /** 
     * Display the constants 
     */
    System.out.println(Size.LARGE);
    System.out.println(Size.TINY);
    System.out.println(Size.MEDIUM);
    System.out.println(Size.SMALL);

    /**
     * Switch
     */
    Size size = Size.LARGE;
    switch (size) {
        case LARGE:
            System.out.println("Bigger than 200");
            break;
        case MEDIUM:
            System.out.println("Between 180 and 200");
            break;
        case SMALL:
            System.out.println("Between 165 and 180");
            break;
        case TINY:
            System.out.println("Smaller than 165");
            break;
        default:
            System.out.println("No extreme sizes available");
            break;
    }   
}
}

public class RGBFromArgsMain {
    public static void main(String[] args) {
        if (args.length == 3){
            double red = Double.parseDouble(args[0]);
            double green = Double.parseDouble(args[1]);
            double blue = Double.parseDouble(args[2]);   

            RGB rgb1 = new RGB(red, green, blue);
            rgb1.display();
        }
        else{
            System.out.println("Boring...");
        }
    }
}

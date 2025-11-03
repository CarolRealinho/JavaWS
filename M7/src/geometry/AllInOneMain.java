package geometry;

import java.util.ArrayList;

public class AllInOneMain {
    public static void main(String[] args) {
        ArrayList<AllInOne> arr = new ArrayList<AllInOne>();

        arr.add(new Position(1,2));
        arr.add(new Circle(3, new Position(0,0)));
        arr.add(new Position(5,12));

        for(AllInOne d: arr){
            d.translate(100, 100);
            d.display();
        }
    }
}

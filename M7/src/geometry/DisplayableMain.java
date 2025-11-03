package geometry;

import java.util.ArrayList;

public class DisplayableMain {
    public static void main(String[] args) {
        ArrayList<Displayable> arr = new ArrayList<Displayable>();

        arr.add(new Position(1,2));
        arr.add(new Circle(3, new Position(0,0)));
        arr.add(new Position(5,12));

        for(Displayable d: arr){
            d.display();
        }
    }
}

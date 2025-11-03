package geometry;

import java.util.ArrayList;

public class ManipulableMain {
    public static void main(String[] args) {
        ArrayList<Manipulable> arr = new ArrayList<Manipulable>();

        arr.add(new Position(1,2));
        arr.add(new Circle(3, new Position(0,0)));
        arr.add(new Position(5,12));

        for(Manipulable d: arr){
            d.translate(100, 100);
        }

        System.out.println(arr);
    }
}

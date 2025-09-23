package maps;

import java.util.ArrayList;
import java.util.HashMap;
import geometry.Position;

public class MapListMain {
public static void main(String[] args) {
    /**
     * Create the positions and the array 
     */
    Position p0 = new Position(0,0);
    Position p1 = new Position(0,1);
    Position p2 = new Position(1,0);

    ArrayList<Position> ar1 = new ArrayList<>();
    ar1.add(p0);
    ar1.add(p2);
    ArrayList<Position> ar2 = new ArrayList<>();
    ar2.add(p0);
    ar2.add(p1);

    /**
     * Create the HashMap
     */
    HashMap<String,ArrayList<Position>> posMap = new HashMap<>();
    posMap.put("Segment1", ar1);
    posMap.put("Segment2", ar2);

    System.out.println(posMap);
}
}

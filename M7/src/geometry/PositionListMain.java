package geometry;

import java.util.ArrayList;
import java.util.Collections;

public class PositionListMain {
    public static void main(String[] args) {
        ArrayList<Position> positionList = new ArrayList<Position>();
        positionList.add(new Position(2,1));
        positionList.add(new Position(1,2));
        positionList.add(new Position(1,1));
        positionList.add(new Position(1,3));

        System.out.println(positionList); // insertion order

        Collections.sort(positionList);

        System.out.println(positionList); // only because elements of the list implemented Comparable interface
    }
}

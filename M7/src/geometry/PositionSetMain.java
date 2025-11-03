package geometry;

import java.util.TreeSet;

public class PositionSetMain {
    public static void main(String[] args) {
        TreeSet<Position> positionSet = new TreeSet<Position>();
        positionSet.add(new Position(2,1));
        positionSet.add(new Position(1,2));
        positionSet.add(new Position(1,1));
        positionSet.add(new Position(1,3));

        System.out.println(positionSet); // only works because Position implements Comparable<Position>
    }
}

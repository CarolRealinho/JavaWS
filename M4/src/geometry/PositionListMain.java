package geometry;

import java.util.ArrayList;

public class PositionListMain {
public static void main(String[] args) {
    ArrayList<Position> listOfPos = new ArrayList<>();
    Position pos1 = new Position(2,3);
    Position pos2 = new Position(1,2);
    Position origin = new Position(0,0);
    listOfPos.add(pos1);
    listOfPos.addFirst(origin);
    listOfPos.add(2, pos2);

    for(Position pos: listOfPos){
        pos.toString();
    }
    
    System.out.println(listOfPos);
}
}

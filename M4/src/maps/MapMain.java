package maps;

import java.util.HashMap;
import geometry.Position;

public class MapMain {
public static void main(String[] args) {
    HashMap<String,Position> posMap = new HashMap<>();

    Position pos1 = new Position(0,0);
    Position pos2 = new Position(2,3);
    Position pos3 = new Position(-4,-6);

    posMap.put("Origin", pos1);
    posMap.put("Pi", pos2);
    posMap.put("Pf", pos3);

    System.out.println(posMap);

    for(String key : posMap.keySet()){
        System.out.println(key + ": " + posMap.get(key));
    }
}
}

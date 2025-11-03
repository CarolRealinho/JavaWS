package persons;

import java.util.HashMap;
import java.util.TreeMap;

public class MapsMain {
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<Person,String>();
        map.put(new Person("Liza", 12), "user0");
        System.out.println(map);
        System.out.println(map.containsKey(new Person("Liza", 12)));

        TreeMap<Person,String> tMap = new TreeMap<Person,String>();
        tMap.put(new Person("CRP", 21), "ist1102574");
        tMap.put(new Person("CRZP", 21), "ist1102575");
        System.out.println(tMap);
    }
}

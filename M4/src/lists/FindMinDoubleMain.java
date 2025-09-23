package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindMinDoubleMain {
    public static void main(String[] args) {
        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.addAll(Arrays.asList(-6.0, -3.0, -14.0, -2.0, -8.0, -6.0, -9.0,0.0,1.2)); // est-ce que je peux utiliser cela ?

        /**
         * Use Collections to get the max from the list
         */
        double maxDouble = Collections.max(doubleList);
        System.out.println(maxDouble);

        /**
         * Alternatively, do it by yourself
         */
        double max = doubleList.get(0); 
        for(Double db: doubleList){
            if (db>max){
                max = db;
            }
        }
        System.out.println(max);
    }
}

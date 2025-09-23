package algos;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsAlgorithmsMain {
    public static void main(String[] args) {
        ArrayList<Double> listDouble = new ArrayList<>();
        int N = 5;

        // Create a list with 5 random numbers
        for(int i =0;i<N;i++){
            listDouble.add(Math.random());
        }

        System.out.println(listDouble.toString());

        // Sort list in ascending order
        Collections.sort(listDouble);
        System.out.println(listDouble.toString());

        // Shuffle list randomly
        Collections.shuffle(listDouble);
        System.out.println(listDouble.toString());

        // Maximum and minimum
        System.out.println(Collections.max(listDouble));
        System.out.println(Collections.min(listDouble));
    }
    
}

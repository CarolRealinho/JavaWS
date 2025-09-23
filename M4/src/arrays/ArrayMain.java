package arrays;

import java.util.Arrays;

public class ArrayMain {
public static void main(String[] args) {
    int[] arrayNum = {1,2,3,4,5};
    for(int value:arrayNum){
        System.out.println(value);
    }
    
    int[][] mat2x2 = { { 1, 2 }, { 3, 4 } };
    // int x = mat2x2[0][0];
    mat2x2[0][0] = 12;

    System.out.println(Arrays.deepToString(mat2x2));


}
}

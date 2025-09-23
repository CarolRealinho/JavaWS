package arrays;

public class FindMinMain {
    public static void main(String[] args) {
        int[] array = { 6, 3, 14, 2, 8, 6, 9 };
        int min = array[0];
        /** 
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        } */
        
        for(int value:array){
            if(value<min){
                min = value;
            }
        }
        System.out.println(min);
    }
}

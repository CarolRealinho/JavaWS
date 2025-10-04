package datapool;

public class DataPoolMain {
    public static void main(String[] args) {
        DataPool<String> data = new DataPool<String>(3);
        int a = data.add("A");
        int b = data.add("B");

        System.out.println(a);
    }
}

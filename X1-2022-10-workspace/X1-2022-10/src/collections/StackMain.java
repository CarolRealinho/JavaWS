package collections;

public class StackMain {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        // Empilez
        s.push("A");
        s.push("B");
        s.push("C");
        // Depiler
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

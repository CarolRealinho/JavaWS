package stacks;

public class WrongStackMain {
    public static void main(String[] args) {
        Stack<String> s = new WrongStack<String>();
        WrongStack<String> stackStr = (WrongStack<String>) s;

        stackStr.push("First");
        stackStr.push("Second");
        stackStr.push("Third");
        stackStr.add(1, "EvilSecond"); // ajouter un element en 2e position 

        System.out.println(stackStr);

        stackStr.set(2, "EvilThird"); // remplacer le 3e element 

        System.out.println(stackStr);

        stackStr.remove(1); // supprimer le 2e element
        
        System.out.println(stackStr);
    }
}

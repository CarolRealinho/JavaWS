package tree;

public class TreeMain {
    public static void main(String[] args) {
        Tree<String> root = new Tree<>("A");

        root.addChild("A", "B");
        root.addChild("A", "C");
        root.addChild("A", "D");
        root.addChild("D", "E");
        root.addChild("D", "F");

        System.out.println(root.toString());
        System.out.println("Size: " + root.size());
        //System.out.println("Height: " + root.height());
    }
}

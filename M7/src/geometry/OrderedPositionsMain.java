package geometry;

public class OrderedPositionsMain {
    public static void main(String[] args) {
        Position p1 = new Position(1,2);
        Position p2 = new Position(0,0);
        Position p3 = new Position(-5,15);
        Position p4 = new Position();

        System.out.println(p1.compareTo(p2));
        System.out.println(p3.compareTo(p2));
        System.out.println(p4.compareTo(p2));
    }
}

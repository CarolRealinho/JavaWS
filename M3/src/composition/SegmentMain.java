package composition;

public class SegmentMain {
    public static void main(String[] args) {
        Position p1 = new Position(0,0);
        Position p2 = new Position(1,0);

        Segment s = new Segment(p1, p2);

        System.out.println("Initial segment:");
        s.display();

        // Try to change p1 after segment creation
        p1.moveTo(99,99);

        System.out.println("After moving original p1 (should NOT affect segment):");
        s.display();
    }
}

public class SegmentMain {
public static void main(String[] args) {
    Position p0 = new Position(1, 2);
    Position p1 = new Position(3, 4);
    Segment seg = new Segment(p0, p1);
    seg.display();
    seg.moveTo(5, 6, 7, 8);
    seg.display();
    p0.display();
    p1.display();

    seg.translate(2, 2);
    seg.display();
}
}

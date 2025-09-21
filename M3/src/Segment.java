import javafx.geometry.Pos;

/**
 * Class representing a segment
 */
public class Segment {
    /** Beginning */
    private Position beg;
    /** End */
    private Position end;

    /**
     * Initialize the segment with the 
     * specified beginning and end position
     * 
     * @param pb
     * @param pe
     */
    public Segment(Position pb, Position pe){
        this.beg = new Position(pb);
        this.end = new Position(pe);
    }

    /**
     * Sets the segment extremes to the specified coordinates
     * 
     * @param xb
     * @param yb
     * @param xe
     * @param ye
     */
    public void moveTo(double xb, double yb, double xe, double ye){
        this.beg.moveTo(xb,yb);
        this.end.moveTo(xe,ye);
    }

    /**
     * Returns the length of the segment
     * 
     * @return
     */
    public double length() {
        return Position.distance(this.beg, this.end);
    }

    /**
     * Displays the coordinates of the beginning and the end points
     * 
     * @return
    */
    public void display(){
        System.out.print("beg = ");
        this.beg.display();
        System.out.print("end = ");
        this.end.display();
    }

    /**
     * Translates the segment initial and
     * final position by a vector
     */
    public void translate(double dx, double dy){
        this.beg.translate(dx, dy);
        this.end.translate(dx, dy);
    }
}
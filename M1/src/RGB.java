public class RGB {
    /** Red */
    private double r;
    /** Green */
    private double g;
    /** Blue */
    private double b;

    /**
     * Initializes a newly created position to the specified coordinates
     * @param r0 
     * @param g0 
     * @param b0
     */
    public RGB(double r0, double g0, double b0) {
        this.r = r0;
        this.g = g0;
        this.b = b0;
    }

    public void display () {
        System.out.println("[" + this.r + ", " + this.g + ", " + this.b + "]");
    }

    public double greyLevel() {
        return (this.r + this.g + this.b)/3;
    }
    
    public void turnToGrey() {
        double nextLevel = greyLevel();
        this.r = nextLevel;
        this.g = nextLevel;
        this.b = nextLevel;
    }    
}
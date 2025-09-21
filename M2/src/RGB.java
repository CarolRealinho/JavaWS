public class RGB {
    final static public double MIN_RANGE = 0.0;
    final static public double MAX_RANGE = 1.0;
    /** Red */
    private double red;
    /** Green */
    private double green;
    /** Blue */
    private double blue;

    /**
     * Initializes a newly created position to the specified coordinates
     * @param r0 
     * @param g0 
     * @param b0
     */
    public RGB(double r0, double g0, double b0) {
        this.red = r0;
        this.green = g0;
        this.blue = b0;
    }

    public void display () {
        System.out.println("[" + this.red + ", " + this.green + ", " + this.blue + "]");
    }

    public double greyLevel() {
        return (this.red + this.green + this.blue)/3;
    }

    /** 
     * Verifies that the specified value is between 0 and 1 
     */
    public static boolean isValueInRange(double value) {
        return value>=0 && value <=1;
    }
    
    public void turnToGrey() {
        double nextLevel = greyLevel();
        this.red = nextLevel;
        this.green = nextLevel;
        this.blue = nextLevel;
    }    

    public boolean equals(RGB other) {
        if (other==null){
            return false;
        }
        if (other==this){
            return true;
        }

        return this.red == other.red && this.green == other.green && this.blue==other.blue;
    }

    public boolean hasValuesInRange() {
        return (this.red<= MAX_RANGE && this.green<=MAX_RANGE && this.blue<=MAX_RANGE && this.red >=MIN_RANGE && this.green>= MIN_RANGE && this.blue>= MIN_RANGE);
    }
}
package rng;

import java.util.Random;

public class UniformRNG extends AbstractRNG{
    private double a;
    private double b;

    public UniformRNG(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double genSample(){
        Random r = new Random();
        return r.nextDouble(this.a,this.b);
    }

    public String toString(){
        return "U(" + this.a + "," + this.b + ")";
    }
}

    

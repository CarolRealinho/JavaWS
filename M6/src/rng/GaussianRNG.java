package rng;

import java.util.Random;

public class GaussianRNG extends AbstractRNG {
    private double mu;
    private double sigma;

    public GaussianRNG(double mu, double sigma){
        this.mu = mu;
        this.sigma = sigma;
    }

    public double genSample(){
        Random r = new Random();
        return r.nextGaussian(this.mu,this.sigma);
    }

    public String toString(){
        return "N(" + this.mu + "," + this.sigma + ")";
    }
}

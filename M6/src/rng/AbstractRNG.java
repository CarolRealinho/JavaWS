package rng;

import java.util.ArrayList;
import java.util.Random;

abstract public class AbstractRNG {
    protected Random rand;
    protected AbstractRNG(){
        this.rand = new Random();
    }

    public ArrayList<Double> genSample(int nb){
        ArrayList<Double> result = new ArrayList<Double>();
        for(int i = 0; i<nb ; i++){
            result.add(this.genSample());
        }
        return result;
    }    

    abstract public double genSample();
}
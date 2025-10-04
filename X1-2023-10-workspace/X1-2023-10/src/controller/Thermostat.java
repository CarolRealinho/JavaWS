package controller;

public class Thermostat {
    public final static double STANDARD_TEMPERATURE = 21.0;
    public final static double MIN_TEMPERATURE = 17.0;
    public final static double MAX_TEMPERATURE = 25.0;

    private String location;
    private double nominal;

    public Thermostat(String location){
        this.location = location;
        this.nominal = Thermostat.STANDARD_TEMPERATURE;
    }

    public double getNominal(){
        return this.nominal;
    }

    public String toString(){
        return this.location +" : " + this.nominal + "°";
    }

    public void setNominal(double temp){
        if(temp<Thermostat.MIN_TEMPERATURE){
            this.nominal = Thermostat.MIN_TEMPERATURE;
        }
        else if(temp>Thermostat.MAX_TEMPERATURE){
            this.nominal = Thermostat.MAX_TEMPERATURE;
        }
        else{
            this.nominal = temp;
        }
    }
}

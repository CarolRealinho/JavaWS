package controller;

import java.util.ArrayList;

public class HouseController {
    private ArrayList<Thermostat> devices;

    public HouseController(){
        this.devices = new ArrayList<Thermostat>();
    }

    public void addThermostat(Thermostat t){
        this.devices.add(t);
    }

    public void adjustAll(double delta){
        for(Thermostat t:this.devices){
            t.setNominal(delta+t.getNominal());
        }
    }

    public String toString(){
        return this.devices.toString();
    }
}

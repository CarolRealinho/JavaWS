package geometry;

import java.util.ArrayList;

public class Polyline {
    /**
     * Initialization
     */
    private ArrayList<Position> vertices;

    /** 
     * Constructor
     */
    public Polyline(){
        this.vertices = new ArrayList<>();
    }

    /** 
     * Add a new vertex in the end of the list
     */
    public void addVertex(Position pos){
        //Position posCopy = new Position(pos); // est-ce que ce n'est pas plus correct ?
        this.vertices.add(pos);
    }

    /**
     * Clears the list of vertices
     */
    public void clearVertices() {
        this.vertices.clear();
    }

    /**
     * Return the number of vertices
     */
    public int size(){
        return this.vertices.size();
    }

    /**
     * Read the coordinates of the ith position of the polyline
     * @param index
     * @return
     */
    public Position getCoordinates(int index){
        return this.vertices.get(index);
    }

    public double getXPosition(int index){
        return this.vertices.get(index).getX();
    }

    public double getYPosition(int index){
        return this.vertices.get(index).getY();
    }

    /**
     * Calculate total length of the line
     */
    public double length(){
        double len = 0.0;
        for(int i =0;i<vertices.size()-1;i++){
            len = len+Position.distance(this.vertices.get(i), this.vertices.get(i+1));
        }
        return len;
    }

    /**
     * Print the infos about the line created
     */
    public String toString(){

        return "vertices=" + this.vertices.toString() + " size=" + this.size() + "\nlength=" + this.length();
    }
}

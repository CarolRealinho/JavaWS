package pathfinder;

import java.util.ArrayList;

public class GraphNode<E> {
    private E element;
    private ArrayList<GraphNode<E>> neighbors;

    public GraphNode(E elem){
        this.element = elem;
        this.neighbors = new ArrayList<GraphNode<E>>();
    }

    public E getElem(){
        return this.element;
    }

    public ArrayList<GraphNode<E>> getNei(){
        return this.neighbors;
    }

    public void addNeighbors(GraphNode<E> n){
        this.neighbors.add(n);
    }
}

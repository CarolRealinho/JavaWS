package pathfinder;

import java.util.HashMap;

public class Graph<E> {
    private HashMap<E,GraphNode<E>> lookup;

    public Graph(){
        this.lookup = new HashMap<E,GraphNode<E>>();
    }

    public void addEdge(E from, E to) {
        // create nodes if they don't exist
        lookup.putIfAbsent(from, new GraphNode<>(from));
        lookup.putIfAbsent(to, new GraphNode<>(to));

        GraphNode<E> nodeFrom = lookup.get(from);
        GraphNode<E> nodeTo = lookup.get(to);

        // prevent duplicate edges
        if (!nodeFrom.getNei().contains(nodeTo)) {
            nodeFrom.addNeighbors(nodeTo);
            nodeTo.addNeighbors(nodeFrom); // undirected graph
        }
    }

    public boolean hasPath(E start, E end) {
        GraphNode<E> startNode = lookup.get(start);
        GraphNode<E> endNode = lookup.get(end);
        if (startNode == null || endNode == null) {
            return false;
        }
        return hasPath(startNode, endNode);
    }

    private boolean hasPath(GraphNode<E> current, GraphNode<E> target) {
        if (current == target) return true;

        for (GraphNode<E> n : current.getNei()) {
            if (hasPath(n, target)) {
                return true;
            }
        }
        return false;
    }
}

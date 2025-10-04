package tree;

import java.util.ArrayList;

public class Node<E> {
    private E element;
    private ArrayList<Node<E>> children; 

    // why is the test about visibility still complaining?
    Node(E element){
        this.element = element;
        this.children = new ArrayList<Node<E>>();
    }

    void addChild(Node<E> child){
        children.add(child); 
    }

    int height(){
        if(children.isEmpty()){
            return 1;
        }

        int maxHgt = 0;
        for(Node<E> n:this.children){
            int childHgt = n.height();
            if (childHgt>maxHgt){
                maxHgt=childHgt;
            }
        }
        return 1+maxHgt;
    }

    /**protected int height(){
        return -1;
    }*/

    /**protected int size(){
        return this.children.size();  // only counts immediate children
    }*/

    int size(){
        int sizeTree = 1;
        for(Node<E> n:this.children){
            sizeTree += n.size();
        }
        return sizeTree;
    }

    public String toString(){
        return toString(0);
    }

    // manual verification only?
    private String toString(int level){
        String finalStr = "  ".repeat(level) + this.element + "\n";
        for(Node<E> n: this.children){
            finalStr += n.toString(level+1);
        }
        return finalStr;
    }
}

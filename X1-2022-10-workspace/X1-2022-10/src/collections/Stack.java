package collections;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> elements;

    public Stack(){
        this.elements = new ArrayList<E>();
    }

    public boolean isEmpty(){
        return this.elements.isEmpty();
    }

    public void push(E element){
        this.elements.add(0,element);
    }

    public E pop(){
        if(this.isEmpty()){
            return null;
        }
        E elem = this.elements.get(0);
        this.elements.remove(0);
        return elem;
    }
}

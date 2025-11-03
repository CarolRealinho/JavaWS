package stacks;

import java.util.ArrayList;

public class WrongStack<E> extends ArrayList<E> implements Stack<E>{
    public WrongStack(){
        super();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public void push(E element){
        this.add(element);
    }

    public E pop(){
        if(!this.isEmpty()){
            E element = this.getLast();
            this.remove(element);
            return element;
        }
        return null;
    }
}

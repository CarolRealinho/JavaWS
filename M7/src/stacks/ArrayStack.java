package stacks;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> elements;

    public ArrayStack() {
        this.elements = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public void push(E element) {
        this.elements.add(element);
    }

    @Override
    public E pop() {
        if (this.elements.isEmpty()) return null;
        E eRem = this.elements.getLast();
        this.elements.remove(eRem);
        return eRem;
    }

    @Override
    public String toString() {
        return this.elements.toString();
    }
}

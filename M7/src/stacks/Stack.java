package stacks;

public interface Stack<E> {
    boolean isEmpty();
    void push(E element);
    E pop();
}

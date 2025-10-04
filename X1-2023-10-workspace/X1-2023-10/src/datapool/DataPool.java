package datapool;

import java.util.TreeMap;

public class DataPool<E> {
    private int capacity;
    private TreeMap<Integer, E> datapool;

    public DataPool(int capacity) {
        this.capacity = capacity;
        this.datapool = new TreeMap<>();
    }

    public boolean isFull() {
        return this.datapool.size() == this.capacity;
    }

    public int add(E element) {
        if (this.datapool.isEmpty()) {
            this.datapool.put(0, element);
            return 0;
        } else if (this.isFull()) {
            // Remove the oldest element (smallest key)
            int oldestKey = this.datapool.firstKey();
            this.datapool.remove(oldestKey);

            // Shift all keys down by 1
            TreeMap<Integer, E> shifted = new TreeMap<>();
            for (int key : this.datapool.keySet()) {
                shifted.put(key - 1, this.datapool.get(key));
            }
            this.datapool = shifted;

            // Add the new element at the last position
            int newKey = this.capacity - 1;
            this.datapool.put(newKey, element);
            return newKey;
        } else {
            int newKey = this.datapool.size();
            this.datapool.put(newKey, element);
            return newKey;
        }
    }

    public E get(int key) {
        return this.datapool.getOrDefault(key, null);
    }

    public void remove(int key) {
        this.datapool.remove(key);
    }

    public double occupancyPercentage() {
        return ((double) this.datapool.size() / this.capacity) * 100.0;
    }

    @Override
    public String toString() {
        if (this.datapool.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int key : this.datapool.keySet()) {
            result.append(this.datapool.get(key)).append(" ");
        }
        return result.toString().trim();
    }
}

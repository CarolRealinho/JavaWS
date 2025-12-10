package io.binary;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import geometry.Position;

/**
 * With an ObjectInputStream, you never read line by line, never split strings, and there is no ready() method.
 */

public class BinaryInputMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream("src/data/data.bin");
        ObjectInputStream in = new ObjectInputStream(fis);

        // Read them in the same order as they were written
        int n = in.readInt();
        double pi = in.readDouble();
        String txt = (String) in.readObject();
        ArrayList<?> arr = (ArrayList<?>) in.readObject();
        Position p0 = (Position) in.readObject();
        ArrayList<?> posList = (ArrayList<?>) in.readObject();

        in.close();

        // Display to verify
        System.out.println("Int: " + n);
        System.out.println("Double: " + pi);
        System.out.println("String: " + txt);
        System.out.println("String list: " + arr);
        System.out.println("Position p0: " + p0);
        System.out.println("List of positions: " + posList);
    }
}

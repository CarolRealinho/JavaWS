package io.binary;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;

import geometry.Position;

public class BinaryOutputMain {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("a");
        arr.add("b");
        arr.add("c");
        Position p0 = new Position(1,2);
        Position p1 = new Position(8,9);
        Position p2 = new Position(5,6);
        ArrayList<Position> pos = new ArrayList<Position>();
        pos.add(p0);
        pos.add(p1);
        pos.add(p2);

        FileOutputStream fos = new FileOutputStream("src/data/data.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(42);
        oos.writeDouble(Math.PI);
        oos.writeObject("toto");
        oos.writeObject(arr);
        oos.writeObject(p0);
        oos.writeObject(pos);
        oos.close();
    }
}

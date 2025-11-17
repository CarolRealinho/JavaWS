package io.text;

import java.io.IOException;
import geometry.Position;

public class BarycenterMain {
    public static void main(String[] args) throws IOException, IllegalArgumentException{
        Position p1 = new Position(1,2);
        Position p2 = new Position(3,8);

        PositionWriter.write(p2, "src/io/text/file.txt", false);
        System.out.println(PositionReader.read("src/io/text/file.txt"));
        
        PositionWriter.write(p1, "src/io/text/file.txt", true);
        System.out.println(PositionReader.read("src/io/text/file.txt"));
    }
}

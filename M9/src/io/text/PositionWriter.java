package io.text;

import java.util.Collection;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import geometry.Position;

public class PositionWriter  {
    static public void write(Position position, String filename, boolean append) throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter(filename,append)); // overwrite
        out.println(position.getX() + ", " + position.getY());
        out.close();
    }
    
    static public void write(Collection<Position> positions, String filename, boolean append) throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter(filename,append));
        for(Position p: positions){
            out.println(p.getX() + ", " + p.getY());
        }
        out.close();
    }

}

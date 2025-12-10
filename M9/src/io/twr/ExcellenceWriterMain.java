package io.twr;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExcellenceWriterMain {
    public static void main(String[] args) {
        try(PrintWriter out = new PrintWriter("./toto/isae.txt")){
            out.println("Excellence with Passion");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }        
    }
}

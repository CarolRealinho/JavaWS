package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThirdLineReader {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/io/dummy.txt"));
        String str = in.readLine(); // stores first line in str
        str = in.readLine(); // next line
        str = in.readLine();
        System.out.println(str);
        in.close();
    }
}

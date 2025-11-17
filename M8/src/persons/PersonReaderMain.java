package persons;

import java.io.IOException;

public class PersonReaderMain {
    public static void main(String[] args) throws IOException{
        System.out.println(PersonReader.read("./data/persons.txt"));
    }
}

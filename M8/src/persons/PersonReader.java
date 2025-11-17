package persons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides a static method to parse a list of persons from a CSV (comma-separated values) file.
 *
 * @author t.perennou
 *
 */
public class PersonReader {
	
	/**
	 * Reads persons from a text file. The file must be in the CSV format:
	 * <ul>
	 * <li> One person per line
	 * <li> Each line must be in the format: 
	 * <pre>
	 * name,age
	 * </pre>
	 * </ul>
	 * 
	 * Here is an example file of CSV file content:
	 * 
	 * <pre>
	 * Jean Dupont,33
	 * Pierre Martin,55
	 * </pre>
 	 * 
	 * @param filename Path of the file to read, e.g. "data/persons.txt"
	 * @return A list of persons in the text file
	 * @throws IOException when the file cannot be read or has a bad format.
	 */
	static public ArrayList<Person> read(String filename) throws IOException, NumberFormatException {
		FileReader in = new FileReader(filename);
		BufferedReader bin = new BufferedReader(in);
		int noLine = 1;
		ArrayList<String> errors = new ArrayList<String>();

		ArrayList<Person> persons = new ArrayList<Person>();
		while(bin.ready()) {
			String line = bin.readLine();
			String[] tokens = line.split(",");

			if (tokens.length < 2) { // Prevents ArrayIndexOutOfBoundsException
        		String anomaly = "Error at line " + noLine + " of the file: Missing age or comma";
        		errors.add(anomaly);
        		noLine++;
        		continue; // skip this malformed line
    		}

			String name = tokens[0].trim();
            try{
                int age = Integer.parseInt(tokens[1].trim());
                persons.add(new Person(name, age));
            }
            catch(NumberFormatException nfe){
				String anomaly = "Error at line " + noLine + " of the file: Age needs to be an integer";
				errors.add(anomaly);
            }
			noLine+=1;
		}
		bin.close();

		System.out.println(errors);
		
		return persons;
	}

}

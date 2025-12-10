package src.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GPSCoordinatesReaderMain {
	
	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("src/exceptions/summits.txt");
		BufferedReader reader = new BufferedReader(fileReader);
		
		while(reader.ready()) {
			String line = reader.readLine();
			String[] words = line.split(",");
			double lat = Double.parseDouble(words[0].trim());
			double lon = Double.parseDouble(words[1].trim());
			double alt = Double.parseDouble(words[2].trim());
			GPSCoordinates coords = new GPSCoordinates(lat, lon, alt);
			System.out.println(coords);
		}
		reader.close();
	}

}

package io.text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import geometry.Position;

public class PositionReader {

	static public List<Position> read(String filename) throws IOException {
		FileReader in = new FileReader(filename);
		BufferedReader bin = new BufferedReader(in);

		List<Position> positions = new ArrayList<Position>();
		
		while(bin.ready()) {
			String line = bin.readLine();
			if(line.trim().isEmpty()) continue;

			String[] tokens = line.split(",");
			if(tokens.length != 2) continue;

			double x = Double.parseDouble(tokens[0].trim());
			double y = Double.parseDouble(tokens[1].trim());
			positions.add(new Position(x, y));
		}
		bin.close();
		
		return positions;
	}

}

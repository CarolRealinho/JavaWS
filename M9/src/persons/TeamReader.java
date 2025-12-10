package persons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;

public class TeamReader {
	static public Map<String,Team> read(String filename, Map<String,Person> persons) throws IOException {
		FileReader in = new FileReader(filename);
		BufferedReader bin = new BufferedReader(in);

		Map<String,Team> table = new TreeMap<>();
		while(bin.ready()) {
			String line = bin.readLine();
			String[] tokens = line.split(",");
			String team_name = tokens[0].trim();
			Team newTeam = new Team(team_name);
			for(int i=1;i<tokens.length;i++){
				Person player = persons.get(tokens[i].trim());
				if(i==1){
					newTeam.setLeader(player);
				}
				else{
					newTeam.addPlayer(player);
				}
				
			}
			table.put(team_name,newTeam);
		}
		bin.close();
		
		return table;
	}

}

package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class League {
	private Conference[] conferences;
	private int numTeams;
	private int playersPerTeam;
	private int WEST = 0;
	private int EAST = 1;
	
	/*
	 * League
	 * Constructor for the League class.
	 * Parameters: numTeams, an int representing the number of teams in all conferences.
	 * 			playersPerTeam, an int representing the numbers of players that will be on each team.
	 * Returns: None
	 */
	public League(int numTeams, int playersPerTeam) {
		this.numTeams = numTeams;
		this.playersPerTeam = playersPerTeam;
		this.conferences = new Conference[2];
		//Make western conference team
		this.conferences[WEST] = new Conference(true, numTeams / 2, playersPerTeam);
		//Make eastern conference team
		this.conferences[EAST] = new Conference(false, numTeams / 2, playersPerTeam);
	}
	
	/*
	 * buildFranchises
	 * Reads from the cities.txt file in Info to initialize all Team objects in conferences.
	 * Parameters: teamNames, the MyHashMap containing the team names.
	 * Returns: None
	 */
	public void buildFranchises(MyHashMap teamNames) {
		String path = "src/Info/cities.txt";
		File nameFile = new File(path);
		Scanner in = null;
		//count starts at 1 to stop loop when all teams are made.
		int count = 1;
		//Use Scanner class to read in from cities.txt
		try {
			in = new Scanner(nameFile);
		} catch (FileNotFoundException e) {
			// Catch FileNotFoundException if cities.txt path incorrect, exit with status -1.
			System.err.println("Could not read " + path + " file.");
			System.exit(-1);
		}
		//Iterate through cities.txt using scanner.
		while (in.hasNextLine()) {
			if (count > numTeams) {
				break;
			}
			String info = in.nextLine();
			String[] splitStr = info.split(",");
			//File contains information on both city and conference.
			String city = splitStr[0];
			String conf = splitStr[1];
			//Randomly get a team name.
			int getThis = (int) (Math.random() * 100) % teamNames.getSize();
			String teamName = teamNames.getAndRemoveName(getThis);
			//Do not want to set a null string to the team name.
			while (teamName == null) {
				getThis = (int) (Math.random() * 100) % teamNames.getSize();
				teamName = teamNames.getAndRemoveName(getThis);
			}
			if (conf.equals("west")) {
				System.out.println("WEST: " + city + " " + teamName);
				conferences[WEST].makeTeam(city, teamName);
			}
			else {
				System.out.println("EAST: " + city + " " + teamName);
				conferences[EAST].makeTeam(city, teamName);
			}
			count++;
		}
		
	}
}

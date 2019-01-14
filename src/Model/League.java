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
				conferences[WEST].makeTeam(city, teamName);
			}
			else {
				conferences[EAST].makeTeam(city, teamName);
			}
			count++;
		}
		
	}
	
	/*
	 * holdDraft
	 * Gives players and coaches directly to teams in order.
	 * Parameters: players, an array of all players and coaches.
	 * Returns: None
	 */
	public void holdDraft(Person[] players) {
		int i = 0;
		boolean drafted = false;
		Team[] westTeams = conferences[WEST].getTeams();
		Team[] eastTeams = conferences[EAST].getTeams();
		//MAKE RANDOM LATER
		while (true) {
			//Don't want to move off of arrays.
			if (i == numTeams / 2) {
				i = 0;
			}
			//Draft, then test for failure.
			drafted = westTeams[i].draftPlayer(players);
			if (!drafted) {
				break;
			}
			drafted = eastTeams[i].draftPlayer(players);
			if (!drafted) {
				break;
			}
			i++;
		}
		i = 0;
		//BUG: SOME COACHES STILL NOT CREATED
		//REPLACE WITH DUD COACHES FOR NOW
		while (i < numTeams / 2) {
			if (westTeams[i].getCoach() == null) {
				drafted = westTeams[i].draftCoach(players);
				if (!drafted) {
					Coach c = new Coach("Dud McGee");
					c.generateStats();
					westTeams[i].setCoach(c);
				}
			}
			if (eastTeams[i].getCoach() == null) {
				drafted = eastTeams[i].draftCoach(players);
				if (!drafted) {
					Coach c = new Coach("Bob Noman");
					c.generateStats();
					westTeams[i].setCoach(c);
				}
			}
			i++;
		}
	}
	
	public void play() {
		Team a = conferences[WEST].getRandomTeam();
		Team b = conferences[EAST].getRandomTeam();
		Game newGame = new Game(a, b);
		newGame.start();
	}
	
	/*
	 * printLeague
	 * Prints out all team names, coaches, and players in league.
	 * Parameters: None
	 * Returns: None
	 */
	public void printLeague() {
		//Create arrays
		Team[] westTeams = conferences[WEST].getTeams();
		Team[] eastTeams = conferences[EAST].getTeams();
		//Print out western conference content.
		System.out.println("---------- WESTERN CONFERENCE -----------");
		for (int i = 0; i < westTeams.length; i++) {
			System.out.println("\n" + westTeams[i].getCity() + " " + westTeams[i].getName() + "\n");
			System.out.println(westTeams[i].getCoach());
			Player[] players = westTeams[i].getPlayers();
			for (int j = 0; j < players.length; j++) {
				System.out.println(players[j]);
			}
		}
		//Print out eastern conference content.
		System.out.println("\n---------- EASTERN CONFERENCE -----------");
		for (int k = 0; k < eastTeams.length; k++) {
			System.out.println("\n" + eastTeams[k].getCity() + " " + eastTeams[k].getName() + "\n");
			System.out.println(westTeams[k].getCoach());
			Player[] players = westTeams[k].getPlayers();
			for (int l = 0; l < players.length; l++) {
				System.out.println(players[l]);
			}
		}
	}
}

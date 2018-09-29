package Model;

public class Team {
	private String city;
	private String name;
	private Player[] players;
	
	/*
	 * Team
	 * Constructor for the Team class.
	 * Parameters: city, the String representing the city of this team.
	 * 			teamName, the String representing the team's name.
	 * 			playerCount, the int representing the number of players on the team.
	 * Returns: None
	 */
	public Team(String city, String teamName, int playerCount) {
		this.city = city;
		this.name = teamName;
		players = new Player[playerCount];
	}
}

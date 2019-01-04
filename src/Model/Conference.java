package Model;

public class Conference {
	private boolean isWestern;
	private Conference[] conferences;
	private Team[] teams;
	private int playersPerTeam;
	//So we can count how many teams are completed
	private int completedTeams;
	
	/*
	 * Conference
	 * Constructor that creates either a western or eastern conference, depending on isWest.
	 * 
	 * Parameters: isWest, will be true if conference is western, false if eastern.
	 * 			numTeams, the number of teams that this conference will contain.
	 * Returns: None
	 */
	public Conference(boolean isWest, int numTeams, int playersPerTeam) {
		this.isWestern = isWest;
		this.playersPerTeam = playersPerTeam;
		this.teams = new Team[numTeams];
		this.completedTeams = 0;
	}
	
	/*
	 * makeTeam
	 * Calls the constructor for the Team objects in teams, giving them their names.
	 * 
	 * Parameters: city, a String representation of the team's city.
	 * 			name, a String representation of the team's name.
	 * Returns: None
	 */
	public void makeTeam(String city, String name) {
		teams[completedTeams] = new Team(city, name, playersPerTeam);
		completedTeams++;
	}
	
	public Team getRandomTeam() {
		int random = (int) (Math.random() * 100) % teams.length;
		return teams[random];
	}
	
	//Getter for array of teams.
	public Team[] getTeams() {
		return teams;
	}
}

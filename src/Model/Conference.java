package Model;

public class Conference {
	private boolean isWestern;
	private Conference[] conferences;
	private Team[] teams;
	private int playersPerTeam;
	//So we can count how many teams are completed
	private int completedTeams;
	
	public Conference(boolean isWest, int numTeams, int playersPerTeam) {
		this.isWestern = isWest;
		this.playersPerTeam = playersPerTeam;
		this.teams = new Team[numTeams];
		this.completedTeams = 0;
	}
	
	public void makeTeam(String city, String name) {
		teams[completedTeams] = new Team(city, name, playersPerTeam);
		completedTeams++;
	}
}

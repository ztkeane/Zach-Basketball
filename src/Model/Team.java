package Model;

public class Team {
	private String city;
	private String name;
	private Player[] players;
	private Coach coach;
	//Ensure that we don't add too many players in certain positions.
	private int PGnum;
	private int SGnum;
	private int SFnum;
	private int PFnum;
	private int Cnum;
	private boolean hasCoach;
	public int numPlayers;
	
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
		this.PGnum = 0;
		this.SGnum = 0;
		this.SFnum = 0;
		this.PFnum = 0;
		this.Cnum = 0;
		this.hasCoach = false;
		this.numPlayers = 0;
	}
	
	/*
	 * draftPlayers
	 * Iterates through the players array, drafting the first, highest rated player.
	 * This process is inefficient, but necessary to avoid skipping talented players.
	 * Parameters: players, an array of either Player or Coach.
	 * Returns: A boolean indicating whether a player was successfully drafted.
	 */
	public boolean draftPlayer(Person[] draftOptions) {
		for (int i = 0; i < draftOptions.length; i++) {
			if (!draftOptions[i].onTeam()) {
				switch (draftOptions[i].getPosition()) {
					case C:
						if (Cnum < 3 && numPlayers < players.length) {
							players[numPlayers] = (Player) draftOptions[i];
							players[numPlayers].setonTeam();
							numPlayers++;
							Cnum++;
							return true;
						}
						break;
					case COACH:
						if (!hasCoach) {
							this.coach = (Coach) draftOptions[i];
							this.coach.setonTeam();
							return true;
						}
						break;
					case PF:
						if (PFnum < 3 && numPlayers < players.length) {
							players[numPlayers] = (Player) draftOptions[i];
							players[numPlayers].setonTeam();
							numPlayers++;
							PFnum++;
							return true;
						}
						break;
					case PG:
						if (PGnum < 3 && numPlayers < players.length) {
							players[numPlayers] = (Player) draftOptions[i];
							players[numPlayers].setonTeam();
							numPlayers++;
							PGnum++;
							return true;
						}
						break;
					case SF:
						if (SFnum < 3 && numPlayers < players.length) {
							players[numPlayers] = (Player) draftOptions[i];
							players[numPlayers].setonTeam();
							numPlayers++;
							SFnum++;
							return true;
						}
						break;
					case SG:
						if (SGnum < 3 && numPlayers < players.length) {
							players[numPlayers] = (Player) draftOptions[i];
							players[numPlayers].setonTeam();
							numPlayers++;
							SGnum++;
							return true;
						}
						break;
					default:
						return false;
				}
			}
		}
		return false;
	}
	
	public boolean draftCoach(Person[] draftOptions) {
		for (int a = 0; a < draftOptions.length; a++) {
			if (draftOptions[a].getPosition() == Position.COACH && !draftOptions[a].onTeam()) {
				this.coach = (Coach) draftOptions[a];
				return true;
			}
		}
		return false;
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public Coach getCoach() {
		return coach;
	}
	
	public void setCoach(Coach c) {
		this.coach = c;
	}
	
	public Player[] getPlayers() {
		return players;
	}
}

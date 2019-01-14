package Model;

public class Game {
	private Team a;
	private Team b;
	private boolean aPossession;
	private Player[][] aRoster;
	private Player[][] bRoster;
	private int aScore = 0;
	private int bScore = 0;
	private int TENDENCYMULTIPLIER = 8;
	
	public Game(Team a, Team b) {
		this.a = a;
		this.b = b;
		this.aPossession = true;
		extractPlayers();
	}
	
	private void extractPlayers() {
		this.aRoster = new Player[5][];
		this.aRoster[0] = a.getPos(Position.PG);
		this.aRoster[1] = a.getPos(Position.SG);
		this.aRoster[2] = a.getPos(Position.SF);
		this.aRoster[3] = a.getPos(Position.PF);
		this.aRoster[4] = a.getPos(Position.C);
		this.bRoster = new Player[5][];
		this.bRoster[0] = b.getPos(Position.PG);
		this.bRoster[1] = b.getPos(Position.SG);
		this.bRoster[2] = b.getPos(Position.SF);
		this.bRoster[3] = b.getPos(Position.PF);
		this.bRoster[4] = b.getPos(Position.C);
	}
	
	//TODO: Make into while loop.
	public void start() {
		boolean endPlay = false;
		//Should be in a while-loop in the future.
		if (aPossession) {
			endPlay = singlePlay(aRoster, bRoster, a);
		}
		else {
			endPlay = singlePlay(bRoster, aRoster, b);
		}
	}
	
	//TODO: Return true if shot is made.
	private boolean singlePlay(Player[][] off, Player[][] def, Team team) {
		int receiver = (int) (Math.random() * 100) % 5;
		//CHANGE FROM 0 ONCE ROTATIONS ARE IMPLEMENTED
		Player offense = off[receiver][0];
		Player defense = def[receiver][0];
		//Having 46 inside, 56 outside should mean much more outside than inside
		int insideTendency = offense.getInsideOffense() * TENDENCYMULTIPLIER;
		int outsideTendency = offense.getOutsideOffense() * TENDENCYMULTIPLIER;
		int totalTendency = insideTendency + outsideTendency;
		int choice = (int) (Math.random() * 99999) % totalTendency;
		int shotOdds;
		//Outside shot
		if (choice > insideTendency) {
			shotOdds = (offense.getOutsideOffense() + team.getCoach().getOffenseBoost()) / 2;
			shotOdds -= defense.getOutsideDefense() / 5;
			System.out.print(offense.getName() + " (" + offense.getOutsideOffense() + ") shoots over " + 
					defense.getName() + " (" + defense.getOutsideDefense() + ") with odds of " + shotOdds);
		}
		else {
			shotOdds = (offense.getInsideOffense() + team.getCoach().getOffenseBoost()) / 2;
			shotOdds -= defense.getInsideDefense() / 5;
			System.out.println(offense.getName() + " (" + offense.getInsideOffense() + ") lays it over " + 
					defense.getName() + " (" + defense.getInsideDefense() + ") with odds of " + shotOdds);
		}
		return false;
	}
	
	
}

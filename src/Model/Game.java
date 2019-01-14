package Model;

public class Game {
	private Team a;
	private Team b;
	private boolean aPossession;
	private Player[][] aRoster;
	private Player[][] bRoster;
	private int aScore = 0;
	private int bScore = 0;
	private int TENDENCYMULTIPLIER = 15;
	
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
	
	//TODO: Implement rebounding.
	public void start() {
		boolean endPlay = false;
		//THESE are temporary testing variables.
		int plays = 120;
		int i = 0;
		//Should be in a while-loop in the future.
		while (i < plays) {
			endPlay = singlePlay(aRoster, bRoster, a);
			endPlay = singlePlay(bRoster, aRoster, b);
			i++;
		}
		/*if (aPossession) {
			endPlay = singlePlay(aRoster, bRoster, a);
		}
		else {
			endPlay = singlePlay(bRoster, aRoster, b);
		}*/
	}
	
	//PROBLEM: SOME ARRAYS HAVE 0 ELEMENTS (AKA ZERO PGs or Cs) MUST FIX!
	private boolean singlePlay(Player[][] off, Player[][] def, Team team) {
		int receiver = (int) (Math.random() * 100) % 5;
		//CHANGE FROM 0 ONCE ROTATIONS ARE IMPLEMENTED
		int emptyCount = 0;
		//Sometimes, there might not be players at a certain position.
		Player offense = off[receiver][0];
		emptyCount = 0;
		Player defense = def[receiver][0];
		//Having 46 inside, 56 outside should mean much more outside than inside
		int insideTendency = offense.getInsideOffense() * TENDENCYMULTIPLIER;
		int outsideTendency = offense.getOutsideOffense() * TENDENCYMULTIPLIER;
		int totalTendency = insideTendency + outsideTendency;
		int choice = (int) (Math.random() * 99999) % totalTendency;
		double shotOdds;
		//Outside shot
		if (choice > insideTendency) {
			shotOdds = (offense.getOutsideOffense() + team.getCoach().getOffenseBoost()) / 2;
			shotOdds -= (defense.getOutsideDefense() + team.getCoach().getDefenseBoost()) / 12;
			System.out.print(team.getName() + ": " + offense.getName() + " (" + offense.getOutsideOffense() + ") shoots a three over " + 
					defense.getName() + " (" + defense.getOutsideDefense() + ") with odds of " + (int) shotOdds + "%");
			int shotOutcome = (int) (Math.random() * 167) % 100;
			if (shotOutcome <= shotOdds) {
				System.out.println(" and hits!");
				if (team.getCity().equals(a.getCity())) {
					aScore += 3;
				}
				else {
					bScore += 3;
				}
				System.out.println("\n" + b.getName() + ": " + bScore + "   " + a.getName() + ": " + aScore + "\n");
				return true;
			}
			System.out.println(" and misses.");
		}
		//Inside shot.
		else {
			shotOdds = (offense.getInsideOffense() + team.getCoach().getOffenseBoost()) / 1.3;
			shotOdds -= (defense.getInsideDefense() + team.getCoach().getDefenseBoost()) / 4;
			System.out.print(team.getName() + ": " + offense.getName() + " (" + offense.getInsideOffense() + ") attempts a two over " + 
					defense.getName() + " (" + defense.getInsideDefense() + ") with odds of " + (int) shotOdds + "%");
			int shotOutcome = (int) (Math.random() * 167) % 100;
			if (shotOutcome <= shotOdds) {
				System.out.println(" and makes it!");
				if (team.getCity().equals(a.getCity())) {
					aScore += 2;
				}
				else {
					bScore += 2;
				}
				System.out.println("\n" + b.getName() + ": " + bScore + "   " + a.getName() + ": " + aScore + "\n");
				return true;
			}
			System.out.println(" and misses.");
		}
		return false;
	}
	
}

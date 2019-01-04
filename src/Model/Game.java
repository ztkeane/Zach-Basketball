package Model;

public class Game {
	private Team a;
	private Team b;
	private boolean aPos;
	private Player[] aPG;
	private Player[] aSG;
	private Player[] aSF;
	private Player[] aPF;
	private Player[] aC;
	private Player[] bPG;
	private Player[] bSG;
	private Player[] bSF;
	private Player[] bPF;
	private Player[] bC;
	
	public Game(Team a, Team b) {
		this.a = a;
		this.b = b;
		this.aPos = true;
		extractPlayers();
	}
	
	private void extractPlayers() {
		this.aPG = a.getPos(Position.PG);
		this.aSG = a.getPos(Position.SG);
		this.aSF = a.getPos(Position.SF);
		this.aPF = a.getPos(Position.PF);
		this.aC = a.getPos(Position.C);
		this.bPG = b.getPos(Position.PG);
		this.bSG = b.getPos(Position.SG);
		this.bSF = b.getPos(Position.SF);
		this.bPF = b.getPos(Position.PF);
		this.bC = b.getPos(Position.C);
	}
	
	//TODO
	public void start() {
		;
	}
	
	
}

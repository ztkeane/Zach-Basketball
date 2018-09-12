package Model;

public class Player extends Person {
	//The inside offensive rating of the player. 99 rating = Shaquille O'Neal.
	private int insideOffense;
	//The outside offensive rating of the player. 99 rating = Stephen Curry.
	private int outsideOffense;
	//The inside defensive rating of the player. 99 rating = Bill Russell.
	private int insideDefense;
	//The outside defensive rating of the player. 99 rating = Kawhi Leonard.
	private int outsideDefense;
	//The rebounding rating of the player. 99 rating = Dennis Rodman.
	private int rebounding;
	//The passing rating of the player, useful when teammates are subpar. 99 rating = Magic Johnson.
	private int passing;
	//The position of the player, which is enumerated to PG, SG, SF, PF, C.
	private Position position;
	
	/*
	 * The Player class will be huge when the project is finished. Player must
	 * constantly interact with other Player objects on the court for an
	 * effective basketball simulation to work.
	 */
	public Player(String name, Position position) {
		super(name);
		this.position = position;
	}

	/*
	 * For now, the below functions are simply getters and setters for the
	 * private variables above.
	 */
	public int getInsideOffense() {
		return insideOffense;
	}

	public void setInsideOffense(int insideOffense) {
		this.insideOffense = insideOffense;
	}

	public int getOutsideOffense() {
		return outsideOffense;
	}

	public void setOutsideOffense(int outsideOffense) {
		this.outsideOffense = outsideOffense;
	}

	public int getInsideDefense() {
		return insideDefense;
	}

	public void setInsideDefense(int insideDefense) {
		this.insideDefense = insideDefense;
	}

	public int getOutsideDefense() {
		return outsideDefense;
	}

	public void setOutsideDefense(int outsideDefense) {
		this.outsideDefense = outsideDefense;
	}

	public int getRebounding() {
		return rebounding;
	}

	public void setRebounding(int rebounding) {
		this.rebounding = rebounding;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}
}

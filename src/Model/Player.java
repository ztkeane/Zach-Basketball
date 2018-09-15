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
	
	/*
	 * The Player class will be huge when the project is finished. Player must
	 * constantly interact with other Player objects on the court for an
	 * effective basketball simulation to work.
	 */
	public Player(String name, Position position) {
		super(name);
		this.setPosition(position);
	}
	
	public void generateStats() {
		if (this.position == Position.PG) {
			int inOffense = (int) (Math.random() * 100) % 77;
			this.insideOffense = 32 + inOffense;
			int outOffense = (int) (Math.random() * 100) % 50;
			this.outsideOffense = 49 + outOffense;
			int inDefense = (int) (Math.random() * 100) % 99;
			this.insideDefense = inDefense;
			int outDefense = (int) (Math.random() * 100) % 50;
			this.outsideDefense = 49 + outDefense;
			int rebounds = (int) (Math.random() * 100) % 99;
			this.rebounding = rebounds;
			int passer = (int) (Math.random() * 100) % 50;
			this.passing = 49 + passer;
			this.overallRating = (int) ((double) this.insideOffense / 0.15 + (double) this.outsideOffense / 0.3 + 
					(double) this.insideDefense / 0.1 + (double) this.outsideDefense / 0.2 + (double) this.rebounding / 0.05 +
					(double) this.passing / 0.2);
		}
		else if (this.position == Position.SG) {
			int inOffense = (int) (Math.random() * 100) % 50;
			this.insideOffense = 49 + inOffense;
			int outOffense = (int) (Math.random() * 100) % 60;
			this.outsideOffense = 39 + outOffense;
			int inDefense = (int) (Math.random() * 100) % 70;
			this.insideDefense = 29 + inDefense;
			int outDefense = (int) (Math.random() * 100) % 50;
			this.outsideDefense = 49 + outDefense;
			int rebounds = (int) (Math.random() * 100) % 99;
			this.rebounding = rebounds;
			int passer = (int) (Math.random() * 100) % 70;
			this.passing = 29 + passer;
			this.overallRating = (int) ((double) this.insideOffense / 0.25 + (double) this.outsideOffense / 0.25 + 
					(double) this.insideDefense / 0.1 + (double) this.outsideDefense / 0.2 + (double) this.rebounding / 0.1 +
					(double) this.passing / 0.1);
		}
		else if (this.position == Position.SF) {
			;
		}
		else if (this.position == Position.PF) {
			;
		}
		else {
			;
		}
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String toString() {
		return this.name;
	}
}

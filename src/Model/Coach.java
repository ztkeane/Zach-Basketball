package Model;

public class Coach extends Person {
	//Increases inside and outside offensive stats for players.
	private int offenseBoost;
	//Increases inside and outside defensive stats for players.
	private int defenseBoost;
	//Increases passing stats for players, resulting in less turnovers.
	private int passingBoost;
	//All coaches have a boost for their players at any given position.
	private Position positionBoost;
	
	/*
	 * This Coach class will mostly be used in the future to store information
	 * about an individual coach, along with their abilities on enhancing
	 * their players respective abilities.
	 */
	public Coach(String name) {
		super(name);
		this.position = Position.COACH;
	}

	/*
	 * generateStats
	 * Generates the coach's attribute boosts to certain players, along with his overall rating.
	 * 
	 * Parameters: None
	 * Returns: None
	 */
	public void generateStats() {
		//Randomly generate all values.
		this.offenseBoost = (int) (Math.random() * 100) % 5;
		this.defenseBoost = (int) (Math.random() * 100) % 5;
		this.passingBoost = (int) (Math.random() * 100) % 5;
		int posBoost = (int) (Math.random() * 100) % 5;
		switch (posBoost) {
			case 0: this.positionBoost = Position.PG;
			case 1: this.positionBoost = Position.SG;
			case 2: this.positionBoost = Position.SF;
			case 3: this.positionBoost = Position.PF;
			case 4: this.positionBoost = Position.C;
		}
		this.overallRating = offenseBoost + defenseBoost + passingBoost;
	}
	
	/*
	 * Below are the getters and setters for all boosts given in the
	 * coaching class.
	 */
	public int getOffenseBoost() {
		return offenseBoost;
	}

	public void setOffenseBoost(int offenseBoost) {
		this.offenseBoost = offenseBoost;
	}

	public int getDefenseBoost() {
		return defenseBoost;
	}

	public void setDefenseBoost(int defenseBoost) {
		this.defenseBoost = defenseBoost;
	}

	public int getPassingBoost() {
		return passingBoost;
	}

	public void setPassingBoost(int passingBoost) {
		this.passingBoost = passingBoost;
	}

	public Position getPositionBoost() {
		return positionBoost;
	}

	public void setPositionBoost(Position positionBoost) {
		this.positionBoost = positionBoost;
	}
	
	/*
	 * toString
	 * Gives ability to print coach's name, along with his attributes.
	 * 
	 * Parameters: None
	 * Returns: None
	 */
	public String toString() {
		String str = "Coach " + this.name + "\n\tOverall: " + Integer.toString(overallRating);
		str += "\n\tOffensive Boost: " + Integer.toString(offenseBoost);
		str += "\n\tDefensive Boost: " + Integer.toString(defenseBoost);
		str += "\n\tPassing Boost: " + Integer.toString(passingBoost);
		str += "\n\tPosition Boost: " + positionBoost.toString();
		return str;
	}
}

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
}

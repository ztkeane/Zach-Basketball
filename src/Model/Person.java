package Model;

public class Person {
	protected String name;
	protected Position position;
	protected int overallRating;
	//Indicates whether player is on a team or not.
	protected boolean onTeam;
	
	/*
	 * Person will mostly be used so we may create data structures containing
	 * both of Person's subclasses, Player and Coach. 
	 */
	public Person(String name) {
		this.name = name;
		this.onTeam = false;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public String toString() {
		return this.name;
	}
	
	public int getOverall() {
		return this.overallRating;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean onTeam() {
		return onTeam;
	}
	
	public void setonTeam() {
		onTeam = true;
	}
	
	/*
	 * This only gives an error and exits the program, because the subclasses of
	 * Person should handle this void function.
	 */
	public void generateStats() {
		System.err.println("Could not generate stats for type Person.");
		System.exit(-1);
	}
}

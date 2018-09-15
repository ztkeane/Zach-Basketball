package Model;

public class Person {
	protected String name;
	protected Position position;
	protected int overallRating;
	
	/*
	 * Person will mostly be used so we may create data structures containing
	 * both of Person's subclasses, Player and Coach. 
	 */
	public Person(String name) {
		this.name = name;
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
	
	/*
	 * This only gives an error and exits the program, because the subclasses of
	 * Person should handle this void function.
	 */
	public void generateStats() {
		System.err.println("Could not generate stats for type Person.");
		System.exit(-1);
	}
}

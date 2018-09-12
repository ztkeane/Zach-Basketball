package Model;

public class Person {
	protected String name;
	
	/*
	 * Person will mostly be used so we may create data structures containing
	 * both of Person's subclasses, Player and Coach. 
	 */
	public Person(String name) {
		this.name = name;
	}
}

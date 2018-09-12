/*
 * Zachary Keane
 * Github: https://github.com/ztkeane/
 * Project: Zach-Basketball
 */

package Controller;
import java.io.*;
import java.util.Scanner;

import Model.MyHashMap;

/*
 * This is where main is located, and where the program's model classes are called
 * from. As of now, all controller does is create a MyHashMap of LinkedLists which
 * contains Nodes. 
 */
public class controller {
	//Constant for number of teams in program.
	private static int NUMBER_OF_TEAMS = 8;
	
	/*
	 * All main does for now is call the getPlayers() function to receive a MyHashMap,
	 * and prints out the contents of this MyHashMap, which should be all created players
	 * and their names. 
	 * Parameters: No args are supplied in the command line.
	 * Returns: None
	 */
	public static void main(String[] args) {
		MyHashMap nameMap = getNames();
		MyHashMap playerMap = createPlayers(nameMap);
		generatePlayers(playerMap); //perhaps make this an ArrayList<Person>?
		playerMap.printContents();
		System.exit(0);
	}
	
	/*
	 * getPlayers() creates a MyHashMap that contains all names from the names.txt file
	 * under the Info directory. All names will be capitalized.
	 * Parameters: None
	 * Returns: nameMap, a MyHashMap with capitalized names.
	 */
	private static MyHashMap getNames() {
		MyHashMap nameMap = new MyHashMap();
		//Read in path to names.txt, the file where we will get our names from.
		File nameFile = new File("src/Info/names.txt");
		Scanner in = null;
		//Use Scanner class to read in from names.txt
		try {
			in = new Scanner(nameFile);
		} catch (FileNotFoundException e) {
			// Catch FileNotFoundException if names.txt path incorrect, exit with status 1.
			System.err.println("Could not read names.txt file.");
			System.exit(-1);
		}
		//Read line-by-line and hash the names.
		while (in.hasNextLine()) {
			String newName = in.nextLine();
			//Be sure to capitalize names, to give appearance of a title.
			newName = newName.substring(0, 1).toUpperCase() + newName.substring(1);
			//MyHashMap will hash the name into the proper location.
			nameMap.insert(newName);
		}
		return nameMap;
	}
	
	/*
	 * createPlayers(MyHashMap) will create another MyHashMap, except with both
	 * first and last names that are randomly generated for players.
	 * Parameters: names, the MyHashMap of names that was generated in the getNames() function.
	 * Returns: players, the MyHashMap of full names.
	 */
	private static MyHashMap createPlayers(MyHashMap names) {
		MyHashMap players = new MyHashMap();
		//This for-loop iterates such that each team should have at least 12 players and a coach.
		for (int i = 0; i < (NUMBER_OF_TEAMS * 13); i++) {
			String playerName = "";
			//We will use Math.random(), which generates a random double between 0-1, and fit it to our needs.
			int firstNameIndex = (int) (Math.random() * 100) % 50;
			//Make sure we don't read from a null entry in MyHashMap
			while (names.getName(firstNameIndex) == null) {
				firstNameIndex = (int) (Math.random() * 100) % 50;
			}
			//Add first name to the player name.
			playerName += names.getName(firstNameIndex);
			//Do the same above but with a last name.
			int lastNameIndex = (int) (Math.random() * 100) % 50;
			while (names.getName(lastNameIndex) == null) {
				lastNameIndex = (int) (Math.random() * 100) % 50;
			}
			playerName += " " + names.getName(lastNameIndex);
			//Finally, insert the full name into the new MyHashMap.
			players.insert(playerName);
		}
		return players;
	}
	
	//this should generate players of type 
	private static void generatePlayers(MyHashMap players) {
		;
	}
}

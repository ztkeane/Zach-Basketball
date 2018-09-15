/*
 * Zachary Keane
 * Github: https://github.com/ztkeane/
 * Project: Zach-Basketball
 */

package Controller;
import java.io.*;
import java.util.Scanner;

import Model.*;

/*
 * This is where main is located, and where the program's model classes are called
 * from. As of now, all controller does is create a MyHashMap of LinkedLists which
 * contains Nodes. 
 */
public class controller {
	//Constant for number of teams in program.
	private static int NUMBER_OF_TEAMS = 8;
	private static int PLAYERS_IN_TEAMS = 13;
	
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
		Person[] players = generatePlayers(playerMap);
		System.out.println("Players:");
		for (int i = 0; i < NUMBER_OF_TEAMS * PLAYERS_IN_TEAMS; i++) {
			System.out.println(players[i] + " " + players[i].getPosition());
		}
		System.out.println("\nplayerMap:");
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
			// Catch FileNotFoundException if names.txt path incorrect, exit with status -1.
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
		//This for-loop iterates such that we can fill all rosters.
		for (int i = 0; i < (NUMBER_OF_TEAMS * PLAYERS_IN_TEAMS); i++) {
			String playerName = "";
			//We will use Math.random(), which generates a random double between 0-1, and fit it to our needs.
			int firstNameIndex = (int) (Math.random() * 100) % names.getSize();
			//Make sure we don't read from a null entry in MyHashMap
			while (names.getName(firstNameIndex) == null) {
				firstNameIndex = (int) (Math.random() * 100) % names.getSize();
			}
			//Add first name to the player name.
			playerName += names.getName(firstNameIndex);
			//Do the same above but with a last name.
			int lastNameIndex = (int) (Math.random() * 100) % names.getSize();
			while (names.getName(lastNameIndex) == null) {
				lastNameIndex = (int) (Math.random() * 100) % names.getSize();
			}
			playerName += " " + names.getName(lastNameIndex);
			//Finally, insert the full name into the new MyHashMap.
			players.insert(playerName);
		}
		return players;
	}
	
	//this should generate players of type 
	private static Person[] generatePlayers(MyHashMap players) {
		int size = NUMBER_OF_TEAMS * PLAYERS_IN_TEAMS;
		String[] stringArray = players.dump(size);
		Person[] personArray = new Person[size];
		//Must split 
		int switchPos = (size - NUMBER_OF_TEAMS) / 5;
		Position pos = Position.PG;
		int i = 0;
		int j = 0;
		//First, we must create all players.
		while (i < size - NUMBER_OF_TEAMS) {
			//Must figure out position generation.
			personArray[i] = new Player(stringArray[i], pos);
			personArray[i].generateStats();
			i++;
			j++;
			//If we've created enough of one position, move onto another.
			if (j == switchPos) {
				if (pos == Position.PG) {
					pos = Position.SG;
				}
				else if (pos == Position.SG) {
					pos = Position.SF;
				}
				else if (pos == Position.SF) {
					pos = Position.PF;
				}
				else if (pos == Position.PF) {
					pos = Position.C;
				}
				else {
					pos = Position.PG;
				}
				j = 0;
			}
		}
		//Then, create coaches. This is separate, so we don't create multiple coaches per team.
		while (i < size) {
			personArray[i] = new Coach(stringArray[i]);
			personArray[i].generateStats();
			i++;
		}
		return personArray;
	}
}

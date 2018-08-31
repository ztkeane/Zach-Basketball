package Controller;
import java.io.*;

import Model.LinkedList;
import Model.MyHashMap;

public class controller {
	public static void main(String[] args) {
		MyHashMap nameMap = getPlayers();
		nameMap.printContents();
	}
	
	private static MyHashMap getPlayers() {
		MyHashMap nameMap = new MyHashMap();
		//initially read in names file
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/zach/Zach-Basketball/src/Info/names.txt"));
			//IMPORTANT: find a way to use relative path here:
			//BufferedReader in = new BufferedReader(new FileReader("../Info/names.txt"));
			String str; String myStr;
			//go through each line, save into a hash map
			while ((str = in.readLine()) != null) {
				myStr = str.substring(0, 1).toUpperCase() + str.substring(1);
				nameMap.insert(myStr);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// file reading exception
			e.printStackTrace();
		} catch (IOException e) {
			// string printing exception
			e.printStackTrace();
		}
		MyHashMap playerMap = makePlayers(nameMap);
		return playerMap;
	}
	
	private static MyHashMap makePlayers(MyHashMap nameMap) {
		MyHashMap playerMap = new MyHashMap();
		for (int i = 0; i < 48; i++) {
			int randomFirst = (int) ((Math.random() * 100) % 50);
			int randomSecond = (int) ((Math.random() * 100) % 50);
			LinkedList myList = playerMap.getName(randomFirst);
			while (myList.getSize() > 0) {
				randomFirst = (int) ((Math.random() * 100) % 50);
				myList = playerMap.getName(randomFirst);
			}
			LinkedList secondList = playerMap.getName(randomFirst);
			while (secondList.getSize() > 0) {
				randomSecond = (int) ((Math.random() * 100) % 50);
				secondList = playerMap.getName(randomSecond);
			}
			String firstName = myList.getString();
			String lastName = secondList.getString();
			String name = firstName + " " + lastName;
			playerMap.insert(name);
		}
		return playerMap;
	}
}

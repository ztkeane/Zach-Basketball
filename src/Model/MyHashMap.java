package Model;

public class MyHashMap {
	//hashMap is an array of LinkedLists, meant to handle collisions through chaining.
	private LinkedList [] hashMap;
	//We will choose a hashMap size of 50 for this project.
	private int size = 50;
	
	/*
	 * The MyHashMap class will serve as a way to quickly access random strings
	 * in O(1) time. 
	 */
	public MyHashMap() {
		this.hashMap = new LinkedList[size];
	}
	
	/*
	 * insert
	 * The insert function hashes a string into an index of hashMap, depending
	 * on the ascii value of the total string.
	 * 
	 * Parameters: k, the String that will be hashed into hashMap.
	 * Return value: None
	 */
	public void insert(String k) {
		//First, we must create a Node, as LinkedList only holds objects of class Node.
        Node newNode = new Node(k);
        //Call the hasher to find the index of insertion.
        int insertionArea = Hasher(k);
        //If index was not initialized, we must avoid inserting into a null LinkedList.
        if (this.hashMap[insertionArea] == null) {
            this.hashMap[insertionArea] = new LinkedList();
        }
        //Finally, add the Node into the insertionArea index.
        this.hashMap[insertionArea].add(newNode);
    }
	
	/*
	 * getName
	 * If the index doesn't lead to null, this will return a String entered into the 
	 * LinkedList at the requested index.
	 * 
	 * Parameters: index, an integer representing the index we're interested in.
	 * Return Value: A String received from calling the LinkedList's getString()
	 * function.
	 */
	public String getName(int index) {
		if (this.hashMap[index] == null) {
			return null;
		}
		return this.hashMap[index].getString();
	}
	
	/*
	 * Hasher
	 * Taking in a String, Hasher will calculate the total ascii value and modulo
	 * this value by 50 so we may enter into a "random" index in the LinkedList
	 * array.
	 * 
	 * Parameters: k, the String being hashed.
	 * Return Value: an integer representing the index at which the String k was
	 * hashed to.
	 */
	private int Hasher(String k) {
        int count = 0;
        for (char myChar : k.toCharArray()) {
            count += (int)myChar;
        }
        count = count % 50;
        return count;
    }
	
	public String[] dump(int ArraySize) {
		String[] array = new String[ArraySize];
		int k = 0;
		for (int i = 0; i < this.size; i++) {
			//BUG HERE
			String[] temp = this.hashMap[i].dumpNames();
			for (int j = 0; j < hashMap[i].getSize(); j++) {
				array[k] = temp[j];
				k++;
			}
		}
		return array;
	}
	
	//getter for the size constant
	public int getSize() {
		return this.size;
	}
	
	/*
	 * printContents
	 * Goes through the LinkedList array, calling each LinkedList's toString()
	 * method to output a visual MyHashMap.
	 */
	public void printContents() {
		for (int i = 0; i < 50; i++) {
			System.out.println(hashMap[i]);
		}
	}
}

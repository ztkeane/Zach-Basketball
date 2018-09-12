package Model;

public class LinkedList {
	private Node head;
	private int size;
	
	/*
	 * This LinkedList class will mostly assist the MyHashMap class in performing
	 * chaining on collisions. In this program, 50 of these LinkedList classes
	 * will be needed
	 */
	public LinkedList() {
		this.head = null;
		size = 0;
	}
	
	/*
	 * add
	 * Adds a node to the end of our linked list.
	 * 
	 * Parameters: newNode, a Node to be inserted at the end of the linked list.
	 * Return Value: None
	 */
	public void add(Node newNode) {
        if (head == null) {
        		head = newNode;
        }
        else {
        		Node walker = head;
        		while (walker.getNext() != null) {
        			walker = walker.getNext();
        		}
        		walker.setNext(newNode);
        }
        size++;
	}
	
	//get a random string from the linked list here
	public String getString() {
		int iterations = (int) ((Math.random() * 100) % size);
		Node walker = head;
		for (int i = 0; i < iterations; i++) {
			walker = walker.getNext();
		}
		return walker.getStr();
	}
    
    /*
     * contains
     * Returns an integer telling how many elements are in the linked list.
     *
     * Arguments:
     * None
     *
     * Return Value: count, an integer telling how many elements are in the linked list.
     */
    public int bucketSize() {
        int count = 0;
        if (this.head == null) {
            return 0;
        }
        else {
            Node walkerNode = this.head;
            while (walkerNode != null) {
                count += 1;
                walkerNode = walkerNode.getNext();
            }
        }
        return count;
    }
    
    /*
     * getSize
     * Simply, a getter for the size of our linked list. Returns an integer.
     */
    public int getSize() {
    		return this.size;
    }
    
    /*
     * toString
     * The string representation of the linked list.
     *
     * Parameters: None
     * Return Value: The String representation of the linked list. Example:
     * 1 -> 2 -> 3
     */
    public String toString() {
        String myStr = "";
        //If head is null, be sure to return an empty String.
        if (this.head == null) {
            ;
        }
        else {
        		//Use a walkerNode to hold a reference to our current Node in iteration.
            Node walkerNode = this.head;
            while (walkerNode != null) {
                myStr += walkerNode.toString();
                //Ensure we don't have a hanging arrow off the last element.
                if (walkerNode.getNext() != null) {
                    myStr += " -> "; //no arrows after last element is found.
                }
                walkerNode = walkerNode.getNext();
            }
        }
        return myStr;
    }
	
}

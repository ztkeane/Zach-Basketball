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
	 * Adds a node to the beginning of our linked list.
	 * 
	 * Parameters: newNode, a Node to be inserted at the beginning of the linked list.
	 * Return Value: None
	 */
	public void add(Node newNode) {
		newNode.setNext(head);
		head = newNode;
        size++;
	}
	
	/*
     * getString()
     * Returns a random String from the Nodes contained in this LinkedList class.
     *
     * Arguments:
     * None
     *
     * Return Value: A String randomly chosen from the LinkedList class.
     */
	public String getString() {
		int iterations = (int) ((Math.random() * 100) % size);
		Node walker = head;
		for (int i = 0; i < iterations; i++) {
			walker = walker.getNext();
		}
		return walker.getStr();
	}
	
	/*
     * removeString()
     * Returns a random String from the Nodes contained in this LinkedList class,
     * then deletes the string.
     *
     * Arguments:
     * None
     *
     * Return Value: The head's corresponding string.
     */
	public String removeString() {
		if (size == 0) {
			return null;
		}
		Node temp = head;
		head = head.getNext();
		size--;
		return temp.getStr();
	}
	
	/*
     * dumpNames
     * Returns a String array of all names in the LinkedList object.
     *
     * Arguments:
     * None
     *
     * Return Value: A String[] array containing all names in this LinkedList object.
     */
	public String[] dumpNames() {
		String[] names = new String[size];
		int i = 0;
		Node walker = head;
		while (walker.getNext() != null) {
			names[i] = walker.getStr();
			i++;
			walker = walker.getNext();
		}
		names[i] = walker.getStr();
		return names;
	}
    
    /*
     * bucketSize
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

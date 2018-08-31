package Model;

public class LinkedList {
	private Node head;
	private int size;
	
	public LinkedList() {
		this.head = null;
		size = 0;
	}
	
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
     * Return Value - count, an integer telling how many elements are in the linked list.
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
    
    public int getSize() {
    		return this.size;
    }
    
    /*
     * toString
     * The string representation of the linked list.
     *
     * Arguments:
     * None
     *
     * Return Value - myStr, the string representation of the linked list.
     */
    public String toString() {
        String myStr = "";
        if (this.head == null) {
            ;
        }
        else {
            Node walkerNode = this.head;
            while (walkerNode != null) {
                myStr += walkerNode.toString();
                if (walkerNode.getNext() != null) {
                    myStr += " -> "; //no arrows after last element is found.
                }
                walkerNode = walkerNode.getNext();
            }
        }
        return myStr;
    }
	
}

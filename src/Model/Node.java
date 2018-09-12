package Model;

public class Node {
	//The name, or title, corresponding to this node.
	private String name;
	//The reference to the next connected Node if in a LinkedList.
	private Node next;
	
	/*
	 * Node is used in this project to assist the LinkedList and MyHashMap
	 * classes in first creating the full names for classes of type Person,
	 * or any of its subclasses.
	 */
	public Node(String name) {
		this.name = name;
	}
	
	/*
	 * Below are getters and setters for the variables declared at the top
	 * of the class.
	 */
	public void setNext(Node nextNode) {
		this.next = nextNode;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String getStr() {
		return this.name;
	}
	
	public String toString() {
		return name;
	}
}

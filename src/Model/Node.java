package Model;

public class Node {
	private String name;
	private Node next;
	
	public Node(String name) {
		this.name = name;
	}
	
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

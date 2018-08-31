package Model;

public class Node {
	private String name;
	private int connections;
	private Node next;
	
	public Node(String name) {
		this.name = name;
		this.connections = 0;
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

	public int getConnections() {
		return connections;
	}
	
	public String toString() {
		return name;
	}
}

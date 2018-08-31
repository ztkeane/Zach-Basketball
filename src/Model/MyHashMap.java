package Model;

public class MyHashMap {
	private LinkedList [] hashMap;
	
	public MyHashMap() {
		this.hashMap = new LinkedList[50];
	}
	
	public void insert(String k) {
        Node newNode = new Node(k);
        int insertionArea = Hasher(k);
        if (this.hashMap[insertionArea] == null) {
            this.hashMap[insertionArea] = new LinkedList(); //if no linked list already exists in the element, create one.
        }
        this.hashMap[insertionArea].add(newNode);
    }
	
	public LinkedList getName(int index) {
		return this.hashMap[index];
	}
	
	private int Hasher(String k) {
        int count = 0;
        for (char myChar : k.toCharArray()) {
            count += (int)myChar;
        }
        count = count % 50;
        return count;
    }
	
	public void printContents() {
		for (int i = 0; i < 50; i++) {
			System.out.println(hashMap[i]);
		}
	}
}

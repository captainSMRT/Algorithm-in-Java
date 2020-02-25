package Lists;

public class Node {
	private String name;
	private int age;
	private Node next;
	private Node prev;

	public Node(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + " | " + age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node node) {
		prev = node;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		next = node;
	}

}

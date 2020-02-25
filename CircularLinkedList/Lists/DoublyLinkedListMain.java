package Lists;

public class DoublyLinkedListMain {
	public static void main(String[] args){
		DoublyLinkedList link = new DoublyLinkedList();
		link.initialize();
		//System.out.println(link.isEmpty());
		Node a001 = new Node("A", 21);
		Node a002 = new Node("B", 24);
		Node a003 = new Node("C", 84);
		Node a004 = new Node("D", 25);
		Node a005 = new Node("E", 16);
		Node a006 = new Node("F", 19);
		Node a007 = new Node("G", 255);
		
		//Adding nodes to the front of the linked list
		link.addFront(a001);
		link.addFront(a002);
		link.addFront(a003);
		link.addFront(a004);
		link.addFront(a007);
		link.addBehind(a005);
		link.addToLeft(a006, a004);
		
		//Displaying the linked lists
		System.out.println();
		link.printAll();
		
		//Forming a circular linked list
		System.out.println();
		link.formPerfectCircle();
		link.printAll();
		
		//Unform a circular linked list
		System.out.println();
		link.removePerfectCircle();
		link.printAll();
		
	}
}

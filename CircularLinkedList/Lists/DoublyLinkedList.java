package Lists;

public class DoublyLinkedList {
	Node head;
	Node tail;
	static boolean perfectCircle = false;
	static int size = 0;
	public void initialize(){
		head = null;
		tail = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void formPerfectCircle(){
		if(isEmpty()){
			System.out.println("Unable to form a circle");
			perfectCircle = false;
		}else{
			head.setPrev(tail);
			tail.setNext(head);
			System.out.println("Circular Linked List initialised");
			perfectCircle = true;
		}
	}
	
	public void removePerfectCircle(){
		if(perfectCircle){
			perfectCircle = false;
			head.setPrev(null);
			tail.setNext(null);
			System.out.println("Circular Linked list uninitialised");
		}else{
			System.out.println("Unable to deform a circle");
		}
	}
	
	public void addFront(Node newNode){
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			size = 1;
			System.out.println("initializing: " + head);
		}else{
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
			size = size + 1;
			System.out.println("Adding as new head...    |    " + "Current: " + head + " Next: " + head.getNext());
		}
	}
	
	public void addBehind(Node newNode){
		if(isEmpty()){
			head = newNode;
			tail = newNode;
			size = 1;
			System.out.println("initializing: " + head);
		}else{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			size = size + 1;
			System.out.println("Adding as new tail...    |    " + "Current: " + tail + " Previous: " + tail.getPrev());
		}
		
	}
	
	public void addToLeft(Node newNode, Node prerequisite){
		boolean exist = false;
		Node temp = head;
		for(int i = 0; i < size; i ++){
			if(temp==prerequisite){
				exist = true;
				break;
			}else{
				temp = temp.getNext();
			}
		}
		if(exist){
			newNode.setPrev(prerequisite.getPrev());
			prerequisite.getPrev().setNext(newNode);
			prerequisite.setPrev(newNode);
			newNode.setNext(prerequisite);
			size = size + 1;
			System.out.println("Adding to left of selected node...    |    " + "Current: " + temp + " Previous: " + temp.getPrev() + " Next: " + temp.getNext());
		}else{
			System.out.println("Unable to add new node because prerequisite node is not found");
		}
	}
	
	public int size(){
		return size;
	}
	
	public void printAll(){
		System.out.println();
		System.out.println("========================List========================");
		Node temp = head;
		for(int i=0; i < size; i ++){
			System.out.println("Current: " + temp + " Previous: " + temp.getPrev() + " Next: " + temp.getNext());
			temp = temp.getNext();
		}
		System.out.println("====================End of List====================");
	}
	
	
}

/*
public void printAll(){
	System.out.println();
	System.out.println("========================List========================");
	Node temp = head;
	if(perfectCircle){
				while (head!=temp){
					System.out.println("Current: " + temp + " Previous: " + temp.getPrev() + " Next: " + temp.getNext());
					temp = temp.getNext();
				}
			}else {
				while(temp!=null){
					System.out.println("Current: " + temp + " Previous: " + temp.getPrev() + " Next: " + temp.getNext());
					temp = temp.getNext();
				}
			}
	System.out.println("====================End of List====================");
*/
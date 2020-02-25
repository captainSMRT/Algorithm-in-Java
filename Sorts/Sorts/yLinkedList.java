package Sorts;

public class yLinkedList {
	public yNode head;
	
	public void initialise(){
		head = null;
	}
	
	public boolean isEmpty(){
		return head==null;
	} 
	
	public void add(yNode x){
		if(isEmpty()){
			head = x;
		}else{
			x.next = head;
			head = x;
		}
	}
	
	public yNode remove(){
		if(!isEmpty()){
			yNode temp = head;
			head = temp.next;
			temp.next = null;
			return temp;
		}else{
			return null;
		}
	}
	
	public void printList(){
			yNode temp = head;
			while(temp!=null){
			System.out.print(temp);
			temp = temp.next;
		}
	}
}
